package ru.geekbrains.gkportal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String login() {
        return "index";
    }
}
