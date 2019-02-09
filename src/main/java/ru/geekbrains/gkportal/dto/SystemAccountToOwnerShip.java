package ru.geekbrains.gkportal.dto;


import lombok.Data;
import ru.geekbrains.gkportal.entity.ContactType;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Data
public class SystemAccountToOwnerShip {
    List<OwnershipRegDTO> ownerships = new ArrayList<>();
    @NotNull(message = "Поле обязательно")
    @Size(min = 2, max = 25, message = "2-5 символов")
    private String firstName;
    @NotNull(message = "Поле обязательно")
    @Size(min = 2, max = 25, message = "2-5 символа")
    private String lastName;
    @NotNull(message = "Поле обязательно")
    @Size(min = 2, max = 25, message = "от 2 до 25 символов")
    private String middleName;
    @Size(min = 0, max = 25, message = "0-25 символов")
    @Email(message = "Почта указана не корректна")
    @NotNull(message = "Поле обязательно")
    @Size(min = 5, max = 25, message = "5-25 символов")
    private String email;
    @ValidPhoneNumber(message = "Телефон указан не корректно")
    @NotNull(message = "Поле обязательно")
    @Size(min = 10, message = "Минимум 10 символов")
    private String phoneNumber;
    private ContactType contactType;
    //private Boolean boughtParkingPlace;

    private Boolean allowContactsSharing;

    private AnswerResultDTO answerResultDTO;
    // Пока бесполезная фигня, но потом прикрутим.

    //private List<String> interestedIn;

    //private String extraInterests;

    //private Integer carsInFamily;

    // private String comments;


    public SystemAccountToOwnerShip() {

    }
}
