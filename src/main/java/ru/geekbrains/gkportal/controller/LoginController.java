package ru.geekbrains.gkportal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
