package ru.geekbrains.gkportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.gkportal.dto.interfaces.SystemAccountDTO;
import ru.geekbrains.gkportal.entity.ContactType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SystemAccountToOwnerShip extends AbstractSystemAccount implements SystemAccountDTO {

    private String password;
    private String matchingPassword;
    private Boolean isRegistration;

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


    public SystemAccountToOwnerShip(Boolean isRegistration) {
        this.isRegistration = isRegistration;
    }
}
