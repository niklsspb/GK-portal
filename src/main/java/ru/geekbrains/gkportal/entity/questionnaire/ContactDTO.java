package ru.geekbrains.gkportal.entity.questionnaire;

import ru.geekbrains.gkportal.entity.OwnershipDTO;

import java.util.Collection;

public interface ContactDTO {

    String getUuid();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    QuestionnaireContactConfirmDTO getQuestionnaireContactConfirm();

    Collection<OwnershipDTO> getOwnerships();

}
