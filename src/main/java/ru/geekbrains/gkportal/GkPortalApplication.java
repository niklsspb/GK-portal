package ru.geekbrains.gkportal;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GkPortalApplication {
    private static final Logger logger = Logger.getLogger(GkPortalApplication.class);

    public static void main(String[] args) {
        logger.info("Application start");
        SpringApplication.run(GkPortalApplication.class, args);
    }
}


