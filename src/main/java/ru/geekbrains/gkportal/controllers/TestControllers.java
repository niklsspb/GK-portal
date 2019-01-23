package ru.geekbrains.gkportal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.gkportal.services.MailService;

@RestController
@RequestMapping("/test")
public class TestControllers {

    private MailService mailService;

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/email")
    public int sendMail() {
        mailService.sendRegistrationMail("admin@chertenok.ru");
        return HttpStatus.OK.value();
    }
}
