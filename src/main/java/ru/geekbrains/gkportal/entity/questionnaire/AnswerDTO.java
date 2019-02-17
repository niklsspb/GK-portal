package ru.geekbrains.gkportal.entity.questionnaire;

import java.util.List;

public interface AnswerDTO {

    String getUuid();

    String getName();

    QuestionDTO getQuestion();

//    List<AnswerResultDTO1> getAnswerResults();

//    void setAnswerResults(List<AnswerResultDTO1> answerResults);

}
