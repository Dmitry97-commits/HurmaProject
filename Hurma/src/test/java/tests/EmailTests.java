package tests;

import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.databind.ObjectMapper;
import gmail.jsonObjects.GmailPageMails;
import gmail.jsonObjects.PageOfMessage;
import gmail.jsonObjects.TokenGmail;
import gmail.jsonObjects.authPages.AuthPage;
import gmail.jsonObjects.authPages.GetAuthPage;
import org.apache.http.client.fluent.Content;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.GmailQuickstart;
import utils.ResourcesUtils;

import java.io.IOException;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.util.List;

public class EmailTests extends EmailBaseTest{

    LoginPage loginPage = new LoginPage();
    AuthPage authPage = new AuthPage();
    GmailQuickstart gmailQuickstart = new GmailQuickstart();

    @Test
    public void checkEmailTest() throws Exception {

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.open(ResourcesUtils.getResources("configs","gmailUrl"));
        authPage.EnterEmail("hurmatest4@gmail.com")
                .enterPassword("V580clenovo")
                .clickToTheSettings()
                .clickGoButton();

        String authCode = GetAuthPage.getAuthCode();
        Content ads = gmailQuickstart.getAuthToken(authCode);
        StringReader reader = new StringReader(ads.toString());
        ObjectMapper mapper = new ObjectMapper();
        TokenGmail token = mapper.readValue(reader, TokenGmail.class);
        Selenide.open("https://mail.google.com/mail/u/0/#inbox");
        GmailPageMails gmailPageMails = new GmailPageMails();
        gmailPageMails
                .getMessageByTitle("HURMA");

        String password = List.of(PageOfMessage.getText()
                        .substring(PageOfMessage.getText()
                                .lastIndexOf("Пароль"))
                        .split(" "))
                        .get(1);
        PageOfMessage
                .clickByLink();
        Selenide.switchTo().window(1);
        loginPage
                .enterEmail("hurmatest4@gmail.com")
                .enterPassword(password)
                .clickSubmit();
    }
}
