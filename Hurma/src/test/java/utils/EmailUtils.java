package utils;

import org.jsoup.Jsoup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class EmailUtils {

    static String inboxHost = "imap.gmail.com";
    static String outboxHost = "smtp.gmail.com";

    public static List<String> waitForMail(String user, String password, String text, int minutes) {
        for (int i = 0; i < minutes; i++) {
            List<String> messages = getMail(user, password, text);
            if (messages.size() > 0) {
                return messages;
            }
            sleepMail(60000);
        }
        return new ArrayList<>();
    }

    public static List<String> getMail(String user, String password, String expectedText) {
        try {
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");

            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");
            store.connect(inboxHost, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();

            List<String> messagesList = new ArrayList<>();
            for(Message message: messages) {
                String messageText = getTextFromMessage(message);
                if(messageText.contains(expectedText))
                    messagesList.add(messageText);
            }


            emailFolder.close(false);
            store.close();

            return messagesList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTextFromMessage(Message message) {
        String result = "";

        try {
            if (message.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                result = getTextFromMimeMultipart(mimeMultipart);
            } else {
                result = message.getContent().toString();
            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        result = result.replaceAll("\n", "")
                .replaceAll("[\\s]+", " ");
//        logger.info("message: " + result);
        System.out.println(result);
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    public static void sendMail(String user, String password, String to, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", outboxHost);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);



        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }

    }

    private static void sleepMail(int i) {
        try {
            sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyMailHasMessage(String user, String password, String text) {
        List<String> messages = waitForMail(user, password, text, 10);

        assertEquals(messages.size(), 1, "Проверка, что найдено одно сообщение с данным текстом в течение 10 минут");
    }
}
