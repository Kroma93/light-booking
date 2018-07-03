package pl.whiteit.booking.light.common.mail;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;

@Stateless
public class MailService {

    @Resource(name = "java:jboss/mail/LightBooking")
    private Session mailSender;

    private Message msg;

    private final String MAIL_PERSONAL = "LIGHT BOOKING";

    private final String MAIL_ADDRESS = "light.booking.serwer@gmail.com";

    public void sendMail(Mail mail) throws MessagingException, UnsupportedEncodingException {
        try {
            prepareMessage(mail);
            sendMessage();

        } catch (MessagingException e) {
            e.printStackTrace();
            throw e;
        }
    }


    private void prepareMessage(Mail mail) throws MessagingException, UnsupportedEncodingException {
        msg = new MimeMessage(mailSender);
        msg.setSubject(mail.subject);
        Multipart content = prepareMultiPart(mail);
        msg.setContent(content);
        addRecipients(mail.addressMail);
        addSender();
        msg.saveChanges();
    }

    private MimeMultipart prepareMultiPart(Mail mail) throws MessagingException {
        MimeMultipart mimeMultipart = new MimeMultipart();
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(mail.content,"text/html; charset=utf-8");
        mimeMultipart.addBodyPart(bodyPart);
        return mimeMultipart;
    }

    private void addRecipients(String recipient) throws AddressException, MessagingException {
        System.out.println("send email to " + recipient);
        msg.addRecipient(RecipientType.TO, new InternetAddress(recipient));

    }

    private void addSender() throws MessagingException, UnsupportedEncodingException {
        InternetAddress internetAddress = new InternetAddress();
        internetAddress.setPersonal(MAIL_PERSONAL, "UTF-8");
        internetAddress.setAddress(MAIL_ADDRESS);
        msg.setFrom(internetAddress);
    }

    private void sendMessage() throws MessagingException {
        Transport.send(msg);
    }
}
