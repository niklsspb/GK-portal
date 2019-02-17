package ru.geekbrains.gkportal.entity.questionnaire;

public interface ContactDTO {

    String getUuid();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    QuestionnaireContactConfirmDTO getQuestionnaireContactConfirm();


}
