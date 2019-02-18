package ru.geekbrains.gkportal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.gkportal.dto.interfaces.SystemAccountDTO;
import ru.geekbrains.gkportal.entity.ContactType;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SystemAccountToOwnerShip implements SystemAccountDTO {

    List<OwnershipRegDTO> ownerships = new ArrayList<>();

    @Size(min = 2, max = 100, message = "{firstName.size}")
    @Pattern(regexp = "^[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{firstName.pattern}")
    @NotBlank(message = "{firstName.notBlank}")
    private String firstName;

    @Size(min = 2, max = 100, message = "{lastName.size}")
    @Pattern(regexp = "^[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{lastName.pattern}")
    @NotBlank(message = "{lastName.notBlank}")
    private String lastName;

    @Size(max = 100, message = "{middleName.size}")
    @Pattern(regexp = "^|[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{middleName.pattern}")
    private String middleName;

    @Size(min = 5, max = 150, message = "{email.size}")
    @Email(message = "{email.validation}")
    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    @Size(min = 10, max = 15, message = "{phoneNumber.size}")
    @NotBlank(message = "{phoneNumber.notBlank}")
    @ValidPhoneNumber(message = "{phoneNumber.validPhoneNumber}")
    private String phoneNumber;

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
