package ru.geekbrains.gkportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.util.MailMessageBuilder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MailService {

    private JavaMailSender sender;
    private MailMessageBuilder builder;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Autowired
    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }

    @Autowired
    public void setBuilder(MailMessageBuilder builder) {
        this.builder = builder;
    }

    public void sendMail(List<String> emails, String subject, String text, boolean isHtml) {
        for (String mail : emails) {
            sendMail(mail, subject, text, isHtml);
        }
    }

    public void sendMail(String email, String subject, String text) {
        sendMail(email, subject, text, true);
    }

    public void sendMail(String email, String subject, String text, boolean isHtml) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setText(text, isHtml);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            executorService.submit(() -> sender.send(message));
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    public void sendRegistrationMail(String email) {
        sendMail(email, "Регистрация на сайте  www.gk-gorod.ru", builder.buildRegistrationEmail());
    }

// TODO: 22.01.19 раскометировать после появления сущьности User
//    public boolean sendRegistrationMail(User user, String password) {
//        return sendMail(
//                user.getEmail(),
//                "регистрация на сайте www.gk-gorod.ru",
//                buildRegistrationEmail(user));
//    }
}