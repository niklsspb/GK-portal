package ru.geekbrains.gkportal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.geekbrains.gkportal.config.TemplateNameConst.MAIN_FORM;
import static ru.geekbrains.gkportal.config.TemplateNameConst.returnShablon;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String main(Model model) {
        return returnShablon(model, MAIN_FORM);
    }

    @RequestMapping("/mscontracts")
    public void mscontracts(HttpServletResponse response, HttpServletRequest request) throws IOException {

        request.getContextPath();
        response.sendRedirect("https://drive.google.com/drive/folders/1FcQcAm99i-Oi9DGBAUs9P8S0c0aEnD3a");
    }
}
