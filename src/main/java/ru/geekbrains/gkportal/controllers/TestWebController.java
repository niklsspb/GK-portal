package ru.geekbrains.gkportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerErrorException;

@Controller
@RequestMapping("/test")
public class TestWebController {

    @GetMapping("all")
    public String permitAllPage(Model model) {
        return "registration-mail";
    }

    @GetMapping("admin")
    public String adminPage() {
        return "test_admin_page";
    }

    @GetMapping("manager")
    public String managerPage() {
        return "test_admin_page";
    }

    @GetMapping("serverErr")
    public String ServerErr(){
        throw new ServerErrorException("test Exception", new Throwable());
    }
}
