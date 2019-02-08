package ru.geekbrains.gkportal.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.gkportal.entity.questionnaire.Answer;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    public List<Answer> copyAnswerList(List<Answer> another) {
        List<Answer> createdList = new ArrayList<>(another.size());
        for (int i = 0; i < another.size(); i++) {
            createdList.add(copy(another.get(i)));
        }
        return createdList;
    }

    public Answer copy(Answer another) {
        return Answer.builder()
                .name(another.getName())
                .sortNumber(another.getSortNumber())
                .build();
    }

}
