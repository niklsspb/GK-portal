package ru.geekbrains.gkportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.geekbrains.gkportal.entity.PropertyType;
import ru.geekbrains.gkportal.service.PropertyService;

import java.util.Properties;

@Configuration
public class MailConfig {

    private PropertyService propertyService;
    @Value("${mail_password}")
    private String defaultPrivatePassword;

    @Autowired
    public void setPropertyService(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    private String getPropertyValue(String propertyName) {
        return propertyService.getPropertyValue(propertyName, PropertyType.MAIL);
    }

    private void setPropertyValue(String propertyName, String propertyValue) {
        propertyService.setPropertyValue(propertyName, propertyValue, PropertyType.MAIL);
    }


    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        String password = getPropertyValue("password");
        if ((!defaultPrivatePassword.isEmpty()) && password.isEmpty()) {
            setPropertyValue("password", defaultPrivatePassword);
            password = defaultPrivatePassword;
        }

        mailSender.setDefaultEncoding(getPropertyValue("default_encoding"));
        mailSender.setHost(getPropertyValue("host"));
        mailSender.setPort(Integer.parseInt(getPropertyValue("port")));
        mailSender.setUsername(getPropertyValue("user_name"));
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", getPropertyValue("transport_protocol"));
        props.put("mail.smtp.auth", getPropertyValue("smtp_auth"));
        props.put("mail.smtp.starttls.enable", getPropertyValue("smtp_starttls_enable"));
        props.put("mail.debug", getPropertyValue("debug"));

        return mailSender;
    }
}
