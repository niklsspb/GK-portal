package ru.geekbrains.gkportal.dto;

import lombok.*;
import ru.geekbrains.gkportal.dto.interfaces.SystemAccountDTO;
import ru.geekbrains.gkportal.entity.ContactType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SystemAccountToOwnerShip extends AbstractSystemAccount implements SystemAccountDTO {

    List<OwnershipRegDTO> ownerships = new ArrayList<>();

    private ContactType contactType;

    //private Boolean boughtParkingPlace;

    private Boolean allowContactsSharing;

    private AnswerResultDTO answerResultDTO;

    private String uuid;
    // Пока бесполезная фигня, но потом прикрутим.

    //private List<String> interestedIn;

    //private String extraInterests;

    //private Integer carsInFamily;

    // private String comments;
}
