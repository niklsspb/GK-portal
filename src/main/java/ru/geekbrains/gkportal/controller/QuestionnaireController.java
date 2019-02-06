package ru.geekbrains.gkportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.service.ContactService;
import ru.geekbrains.gkportal.service.QuestionnaireService;


@Controller
@RequestMapping("questionnaire")
public class QuestionnaireController {

    private QuestionnaireService service;
    private ContactService contactService;

    @Autowired
    public void setService(QuestionnaireService service) {
        this.service = service;
    }

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping//http://localhost:8080/questionnaire?questionnaireId=9342a431-0d1d-413e-9f40-f11c98ba4364
    public String showQuestionnaire(@RequestParam String questionnaireId, Model model) {
        System.out.println(questionnaireId);
        Questionnaire questionnaire = service.findById(questionnaireId);
        model.addAttribute("questionnaire", questionnaire);
        model.addAttribute("contactList", contactService.findAll());
        return "questionnaire";


    }
}
