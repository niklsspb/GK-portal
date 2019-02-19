package ru.geekbrains.gkportal.dto.interfaces;

import ru.geekbrains.gkportal.entity.questionnaire.QuestionnaireConfirmedType;

public interface QuestionnaireContactConfirmDTO {

    String getUuid();

//    QuestionnaireDTO getQuestionnaire();
//
//    ContactDTO getContact();

    boolean isConfirmed();

    QuestionnaireConfirmedType getQuestionnaireConfirmedType();

}
