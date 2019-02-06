package ru.geekbrains.gkportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.*;
import ru.geekbrains.gkportal.service.ContactService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/rest")
public class TestRest {

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("test")
    public Questionnaire permitAllPage(Model model) {
        List<String> uuidList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            uuidList.add(UUID.randomUUID().toString());
        }

        model.addAttribute("uuids", uuidList);


        List<QuestionnaireQuestionAnswer> questionnaireQuestionAnswerList1 = new ArrayList<>(Arrays.asList(
                new QuestionnaireQuestionAnswer("Я не принимаю участия в голосовании (бюллетень остался у меня)", 4),
                new QuestionnaireQuestionAnswer("ЗА", 1),
                new QuestionnaireQuestionAnswer("ПРОТИВ", 2),
                new QuestionnaireQuestionAnswer("Воздержался", 3)
        ));
        questionnaireQuestionAnswerList1.sort(Comparator.comparingInt(QuestionnaireQuestionAnswer::getSortNumber));


        QuestionnaireQuestion qq1 = QuestionnaireQuestion.builder()
                .name("Ваше решение по работе УК Еврогород *")
                .sortNumber(1)
                .required(true)
                .single(true)
                .externalNumber(1)
                .questionnaireQuestionAnswerList(questionnaireQuestionAnswerList1)
                .build();
        questionnaireQuestionAnswerList1.forEach(questionnaireQuestionAnswer -> questionnaireQuestionAnswer.setQuestionnaireQuestion(qq1));


        List<QuestionnaireQuestionAnswer> questionnaireQuestionAnswerList2 = new ArrayList<>(Arrays.asList(
                new QuestionnaireQuestionAnswer("Я не принимаю участия в голосовании (бюллетень остался у меня)", 4),
                new QuestionnaireQuestionAnswer("ЗА", 1),
                new QuestionnaireQuestionAnswer("ПРОТИВ", 2),
                new QuestionnaireQuestionAnswer("Воздержался", 3)
        ));
        questionnaireQuestionAnswerList2.sort(Comparator.comparingInt(QuestionnaireQuestionAnswer::getSortNumber));

        QuestionnaireQuestion qq2 = QuestionnaireQuestion.builder()
                .name("Ваше решение о ставке 35 рублей за квадратный метр *")
                .sortNumber(2)
                .required(true)
                .single(true)
                .externalNumber(2)
                .questionnaireQuestionAnswerList(questionnaireQuestionAnswerList2)
                .build();
        questionnaireQuestionAnswerList2.forEach(questionnaireQuestionAnswer -> questionnaireQuestionAnswer.setQuestionnaireQuestion(qq2));

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
                .questionnaireQuestionList(Arrays.asList(qq1, qq2))
                .build();

        qq1.setQuestionnaire(questionnaire);
        qq2.setQuestionnaire(questionnaire);

//        Contact contact = contactService.findById("27fa708c-394d-43b7-8358-b58050ecfdb8");
        List<Contact> contactList = contactService.findAll();

        contactList.forEach(contact -> {
//            QuestionnaireContactConfirm questionnaireContactConfirm1 = ;

//            List<QuestionnaireContactConfirm> questionnaireContactConfirms = new ArrayList<>();
            QuestionnaireContactConfirm questionnaireContactConfirm = QuestionnaireContactConfirm.builder().questionnaire(questionnaire).questionnaire(questionnaire).confirmCode(UUID.randomUUID().toString()).contact(contact).build();
//            questionnaireContactConfirms.add(questionnaireContactConfirm);

//            if (contact.getQuestionnaireContactConfirm() == null) {
            contact.setQuestionnaireContactConfirm(questionnaireContactConfirm);
//            } else {
//                contact.getQuestionnaireContactConfirm().add(questionnaireContactConfirm);
//            }

            QuestionnaireQuestionAnswer questionAnswer1 = questionnaireQuestionAnswerList1.get((int) (Math.random() * 3));
            questionAnswer1.setQuestionnaireQuestion(qq1);
            if (questionAnswer1.getQqAnswerResults() == null) questionAnswer1.setQqAnswerResults(new ArrayList<>());
            QuestionnaireQuestionAnswerResult answerResult1 = new QuestionnaireQuestionAnswerResult(questionAnswer1, contact);

            QuestionnaireQuestionAnswer questionAnswer2 = questionnaireQuestionAnswerList2.get((int) (Math.random() * 3));
            questionAnswer2.setQuestionnaireQuestion(qq2);
            if (questionAnswer2.getQqAnswerResults() == null) questionAnswer2.setQqAnswerResults(new ArrayList<>());
            QuestionnaireQuestionAnswerResult answerResult2 = new QuestionnaireQuestionAnswerResult(questionAnswer2, contact);


            questionAnswer1.getQqAnswerResults().add(answerResult1);
            questionAnswer2.getQqAnswerResults().add(answerResult2);
            contactService.save(contact);
        });

//        contactService.saveAll(contactList);
        return questionnaire;
    }
}
