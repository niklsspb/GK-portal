package ru.geekbrains.gkportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.Answer;
import ru.geekbrains.gkportal.entity.questionnaire.Question;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.service.AnswerService;
import ru.geekbrains.gkportal.service.ContactService;
import ru.geekbrains.gkportal.service.QuestionnaireService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest")
public class TestRest {

    private ContactService contactService;
    private AnswerService answerService;
    private QuestionnaireService questionnaireService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("test")
    public Questionnaire permitAllPage(Model model) {
        List<String> uuidList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            uuidList.add(UUID.randomUUID().toString());
        }

        model.addAttribute("uuids", uuidList);


        List<Answer> answerList1 = new ArrayList<>(Arrays.asList(
                new Answer("ЗА", 1),
                new Answer("ПРОТИВ", 2),
                new Answer("Воздержался", 3),
                new Answer("Я не принимаю участия в голосовании (бюллетень остался у меня)", 4)
        ));
        List<Answer> answerList2 = answerService.copyAnswerList(answerList1);
        List<Answer> answerList3 = answerService.copyAnswerList(answerList1);
        List<Answer> answerList4 = answerService.copyAnswerList(answerList1);

        Question question1 = Question.builder()
                .name("Ваше решение по работе УК Еврогород *")
                .sortNumber(1)
                .required(true)
                .single(true)
                .externalNumber(1)
                .answers(answerList1)
                .build();

        Question question2 = Question.builder()
                .name("Ваше решение о ставке 35 рублей за квадратный метр *")
                .sortNumber(2)
                .required(true)
                .single(true)
                .externalNumber(2)
                .answers(answerList2)
                .build();

        Question question3 = Question.builder()
                .name("Ваше решение об охране? *")
                .sortNumber(3)
                .required(true)
                .single(true)
                .externalNumber(3)
                .answers(answerList3)
                .build();

        Question question4 = Question.builder()
                .name("Ваше решение об электронном голосовании? *")
                .sortNumber(4)
                .required(true)
                .single(true)
                .externalNumber(4)
                .answers(answerList4)
                .build();

        answerList1.forEach(answer -> answer.setQuestion(question1));
        answerList2.forEach(answer -> answer.setQuestion(question2));
        answerList3.forEach(answer -> answer.setQuestion(question3));
        answerList4.forEach(answer -> answer.setQuestion(question4));

        Questionnaire questionnaire = Questionnaire.builder()
                .name("Опрос о голосовании (exit pool) собственников ЖК Город")
                .from(LocalDateTime.now())
                .to(LocalDateTime.now().plusMonths(1L))
                .description("Члены инициативной группы входящие в состав счетной комиссии выборочно проверят " +
                        "соответствие информации в данном опросе и в бюллетенях в момент подведения итогов первого " +
                        "общего собрания собственников. Доступ к данным имеют ограниченное число членов инициативной " +
                        "группы ЖК Город. Форму должен заполнить каждый собственник отдельно по каждому объекту " +
                        "недвижимости(квартиры, машиноместа), где у него есть доля.")
                .open(true)
                .active(true)
                .inBuildNum(true)
                .useRealEstate(true)
                .questions(Arrays.asList(question1, question2, question3, question4))
                .build();

        question1.setQuestionnaire(questionnaire);
        question2.setQuestionnaire(questionnaire);
        question3.setQuestionnaire(questionnaire);
        question4.setQuestionnaire(questionnaire);

        questionnaireService.save(questionnaire);


        List<Contact> contactList = contactService.findAll();

//        contactList.forEach(contact -> {
//
//            QuestionnaireContactConfirm questionnaireContactConfirm = QuestionnaireContactConfirm.builder().questionnaire(questionnaire).questionnaire(questionnaire).confirmCode(UUID.randomUUID().toString()).contact(contact).build();
//
//            contact.setQuestionnaireContactConfirm(questionnaireContactConfirm);
//
//            QuestionnaireQuestionAnswer questionAnswer1 = answerList1.get((int) (Math.random() * 3));
//            questionAnswer1.setQuestion(question1);
//            if (questionAnswer1.getAnswerResults() == null) questionAnswer1.setAnswerResults(new ArrayList<>());
//            QuestionnaireQuestionAnswerResult answerResult1 = new QuestionnaireQuestionAnswerResult(questionAnswer1, contact);
//
//            QuestionnaireQuestionAnswer questionAnswer2 = answerList2.get((int) (Math.random() * 3));
//            questionAnswer2.setQuestion(question2);
//            if (questionAnswer2.getAnswerResults() == null) questionAnswer2.setAnswerResults(new ArrayList<>());
//            QuestionnaireQuestionAnswerResult answerResult2 = new QuestionnaireQuestionAnswerResult(questionAnswer2, contact);
//
//
//            questionAnswer1.getAnswerResults().add(answerResult1);
//            questionAnswer2.getAnswerResults().add(answerResult2);
//            contactService.save(contact);
//        });

//        contactService.saveAll(contactList);
        return questionnaire;
    }
}
