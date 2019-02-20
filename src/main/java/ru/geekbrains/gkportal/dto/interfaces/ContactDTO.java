package ru.geekbrains.gkportal.dto.interfaces;

import java.util.Collection;

public interface ContactDTO {

    String getUuid();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    QuestionnaireContactConfirmDTO getQuestionnaireContactConfirm();

    Collection<OwnershipDTO> getOwnerships();

    Collection<CommunicationDTO> getCommunications();

}
