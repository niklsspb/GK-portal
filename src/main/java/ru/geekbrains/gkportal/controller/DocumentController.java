package ru.geekbrains.gkportal.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static ru.geekbrains.gkportal.config.TemplateNameConst.*;

@Controller
@RequestMapping("/document")
public class DocumentController {
    private static final Logger logger = Logger.getLogger(DocumentController.class);

    @GetMapping("/faq")
    public String faq(Model model) {
        return returnShablon(model, FAQ_FORM);
    }

    @GetMapping("/oss8")
    public String oss8(Model model) {
        return returnShablon(model, OSS8_FORM);
    }

    @GetMapping("/oss4")
    public String oss4(Model model) {
        return returnShablon(model, OSS4_FORM);
    }

    @GetMapping("/sd1")
    public String sd1(Model model) {
        return returnShablon(model, SD1_FORM);
    }

    @GetMapping("/sd2")
    public String sd2(Model model) {
        return returnShablon(model, SD2_FORM);
    }

    @GetMapping("/sd3")
    public String sd3(Model model) {
        return returnShablon(model, SD3_FORM);
    }

    @GetMapping("/evrogorod")
    public String txt1(Model model) {
        return returnShablon(model, TEXT1_FORM);
    }

    @GetMapping("/pikabu")
    public String txt2(Model model) {
        return returnShablon(model, TEXT2_FORM);
    }

    @GetMapping("/information")
    public String info(Model model) {
        return returnShablon(model, INFO_FORM);
    }


}
