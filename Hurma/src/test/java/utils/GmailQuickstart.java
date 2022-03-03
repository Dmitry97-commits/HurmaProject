package utils;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import org.apache.http.Header;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.*;
import java.security.GeneralSecurityException;

public class GmailQuickstart {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "src/test/java/resources/credentials.json";
    private static final String APPLICATION_NAME = "My Project 99820";
    static Gmail service = null;

    public Content getAuthToken(String code) throws IOException {

        return Request.Post("https://oauth2.googleapis.com/token")
                .bodyForm(Form.form().add("code", code)
                        .add("client_id", "298001694034-17lp4ria2q18r1bbb5hejsrsg47db9f1.apps.googleusercontent.com")
                        .add("client_secret", "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")
                        .add("redirect_uri", "urn:ietf:wg:oauth:2.0:oob")
                        .add("grant_type", "authorization_code").build())
                .execute().returnContent();
    }

    private Gmail getService(String accToken , String refresh) throws IOException, GeneralSecurityException {
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets googleClientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        Credential auth = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(googleClientSecrets.getDetails().getClientId(),
                        googleClientSecrets.getDetails().getClientSecret()).build()
                .setAccessToken(accToken)
                .setRefreshToken(refresh);

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, auth)
                .setApplicationName(GmailQuickstart.APPLICATION_NAME).build();
        return service;
    }

    public void getMessages(String accToken , String refresh, String searchString) throws GeneralSecurityException, IOException {

        Gmail.Users.Messages.List request = getService(accToken ,refresh).users().messages().list("me").setQ(searchString);
        ListMessagesResponse messagesResponse = request.execute();
        request.setPageToken(messagesResponse.getNextPageToken());
        String messageId = messagesResponse.getMessages().get(0).getId();
        Message message = service.users().messages().get("me", messageId).execute();
        String emailBody = StringUtils
                .newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
        System.out.println(emailBody);
    }

}