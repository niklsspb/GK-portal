package ru.geekbrains.gkportal.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.geekbrains.gkportal.entity.PropertyType;
import ru.geekbrains.gkportal.service.PropertyService;

import java.util.Properties;

@Configuration
public class MailConfig {

    private static final Logger logger = Logger.getLogger(MailConfig.class);

    private Environment env;
    private PropertyService propertyService;

    private final static String CHECKSERVERIDENTITY = "true";
    private final static String TRUST = "*";
    private final static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";


    @Autowired
    public void setPropertyService(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
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
        if (logger.isDebugEnabled()) {
            logger.debug("password: " + password);
        }
        String defaultPrivatePassword = env.getProperty("mail.password");
        if (logger.isDebugEnabled()) {
            logger.debug("mail.password: " + password);
        }
        if (defaultPrivatePassword != null && (!defaultPrivatePassword.isEmpty()) && password.isEmpty()) {
            setPropertyValue("password", defaultPrivatePassword);
            password = defaultPrivatePassword;
        }

        mailSender.setDefaultEncoding(getPropertyValue("default_encoding"));
        if (logger.isDebugEnabled()) {
            logger.debug("default_encoding: " + mailSender.getDefaultEncoding());
        }
        mailSender.setHost(getPropertyValue("host"));
        if (logger.isDebugEnabled()) {
            logger.debug("host: " + mailSender.getHost());
        }
        mailSender.setPort(Integer.parseInt(getPropertyValue("port")));
        if (logger.isDebugEnabled()) {
            logger.debug("port: " + mailSender.getPort());
        }
        mailSender.setUsername(getPropertyValue("user_name"));
        if (logger.isDebugEnabled()) {
            logger.debug("user_name: " + mailSender.getUsername());
        }
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();

        props.put("mail.transport.protocol", getPropertyValue("transport_protocol"));
        if (logger.isDebugEnabled()) {
            logger.debug("ail.transport.protocol: " + getPropertyValue("transport_protocol"));
        }
        props.put("mail.smtp.auth", getPropertyValue("smtp_auth"));
        if (logger.isDebugEnabled()) {
            logger.debug("ail.smtp.auth: " + getPropertyValue("smtp_auth"));
        }
        props.put("mail.smtp.starttls.enable", getPropertyValue("smtp_starttls_enable"));
        if (logger.isDebugEnabled()) {
            logger.debug("mail.smtp.starttls.enable: " + getPropertyValue("smtp_starttls_enable"));
        }
        // поддержка ssl yandex mail
        props.put("mail.smtps.ssl.CHECKSERVERIDENTITY", CHECKSERVERIDENTITY);
        if (logger.isDebugEnabled()) {
            logger.debug("mail.smtps.ssl.CHECKSERVERIDENTITY: " + CHECKSERVERIDENTITY);
        }
        props.put("mail.smtps.ssl.TRUST", TRUST);
        if (logger.isDebugEnabled()) {
            logger.debug("mail.smtps.ssl.TRUST: " + TRUST);
        }
        props.put("mail.smtp.SOCKET_FACTORY.class", SOCKET_FACTORY);
        if (logger.isDebugEnabled()) {
            logger.debug("mail.smtp.SOCKET_FACTORY.class: " + SOCKET_FACTORY);
        }

        return mailSender;
    }
}
