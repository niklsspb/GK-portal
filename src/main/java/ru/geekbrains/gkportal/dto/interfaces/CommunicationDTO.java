package ru.geekbrains.gkportal.dto.interfaces;

public interface CommunicationDTO {

    String getUuid();

    CommunicationTypeDTO getCommunicationType();

    String getIdentify();

    boolean isConfirmed();

}
