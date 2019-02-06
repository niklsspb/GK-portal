package ru.geekbrains.gkportal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.questionnaire.Questionnaire;
import ru.geekbrains.gkportal.repository.QuestionnaireRepository;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository repository;

    @Autowired
    public void setRepository(QuestionnaireRepository repository) {
        this.repository = repository;
    }

    public Questionnaire findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
