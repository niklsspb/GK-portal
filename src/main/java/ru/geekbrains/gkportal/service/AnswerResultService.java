package ru.geekbrains.gkportal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.questionnaire.AnswerResult;
import ru.geekbrains.gkportal.repository.AnswerResultRepository;

import java.util.List;

@Service
public class AnswerResultService {

    @Autowired
    private AnswerResultRepository answerResultRepository;

    public void setAnswerResultRepository(AnswerResultRepository answerResultRepository) {
        this.answerResultRepository = answerResultRepository;
    }

    public void saveAll(List<AnswerResult> answerResults) {
        answerResultRepository.saveAll(answerResults);
    }


}
