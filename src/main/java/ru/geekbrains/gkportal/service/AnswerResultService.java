package ru.geekbrains.gkportal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.dto.AnswerResultDTO;
import ru.geekbrains.gkportal.entity.AbstractEntity;
import ru.geekbrains.gkportal.entity.Contact;
import ru.geekbrains.gkportal.entity.questionnaire.*;
import ru.geekbrains.gkportal.repository.AnswerResultRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AnswerResultService {

    private AnswerResultRepository answerResultRepository;
    private QuestionnaireService questionnaireService;
    private ContactService contactService;

    @Autowired
    public void setAnswerResultRepository(AnswerResultRepository answerResultRepository) {
        this.answerResultRepository = answerResultRepository;
    }

    @Autowired
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public void saveAll(List<AnswerResult> answerResults) {
        answerResultRepository.saveAll(answerResults);
    }

    public void saveAll(AnswerResultDTO answerResultDTO) throws Throwable {
        saveAnswerResultDTO(answerResultDTO);
    }

    public void saveAnswerResultDTO(AnswerResultDTO answerResultDTO) throws Throwable {
        Questionnaire questionnaire = questionnaireService.findById(answerResultDTO.getQuestionnaireId());

        Contact contact = contactService.createContact(answerResultDTO);
        Collection<Question> questions = questionnaire.getQuestions();
        QuestionnaireContactConfirm questionnaireContactConfirm = QuestionnaireContactConfirm.builder()
                .questionnaire(questionnaire)
                .confirmCode(UUID.randomUUID().toString())
                .contact(contact)
                .build();
        contact.setQuestionnaireContactConfirm(questionnaireContactConfirm);

        Map<String, Answer> answers = new HashMap<>();

        for (Question question : questions) {
            answers.putAll(question.getAnswers().stream().collect(Collectors.toMap(AbstractEntity::getUuid, Function.identity())));
        }

        List<AnswerResult> answerResults = new ArrayList<>();
        //// TODO: 07.02.19 поиск списка ответов по id  перенести в сервис
        for (Map.Entry<String, String> entry : answerResultDTO.getQuestionAnswerUuids().entrySet()) {
            Answer answer = answers.get(entry.getValue());

            answerResults.add(new AnswerResult(answer, contact));

        }

        saveAll(answerResults);
    }

}
