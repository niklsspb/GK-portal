package ru.geekbrains.gkportal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.questionnaire.Answer;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.repository.QuestionnaireRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository repository;

    @Autowired
    public void setRepository(QuestionnaireRepository repository) {
        this.repository = repository;
    }

    public Questionnaire findById(String id) {
        Questionnaire questionnaire = repository.findById(id).orElse(null);

        if (questionnaire != null) {
            questionnaire.getQuestions().forEach(questionnaireQuestion ->
                    questionnaireQuestion.getAnswers()
                            .sort(Comparator.comparingInt(Answer::getSortNumber)));
        }
        return questionnaire;
    }

    public Questionnaire save(Questionnaire questionnaire) {
        return repository.save(questionnaire);
    }

    public List<Questionnaire> findAll() {
        return repository.findAll();
    }
}
