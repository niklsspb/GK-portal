package ru.geekbrains.gkportal.dto;

import lombok.*;
import ru.geekbrains.gkportal.entity.ContactType;
import ru.geekbrains.gkportal.validation.PasswordsNotEqual;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordsNotEqual(
        passwordFieldName = "password",
        passwordVerificationFieldName = "matchingPassword",
        message = "{password.passwordNotEqual}"
)
public class SystemAccount implements SystemAccountDTO {

    @Size(min = 3, max = 100, message = "{firstName.size}")
    @Pattern(regexp = "^[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{firstName.pattern}")
    @NotBlank(message = "{firstName.notBlank}")
    private String firstName;

    @Size(min = 3, max = 100, message = "{lastName.size}")
    @Pattern(regexp = "^[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{lastName.pattern}")
    @NotBlank(message = "{lastName.notBlank}")
    private String lastName;

    @Size(max = 100, message = "{middleName.size}")
    @Pattern(regexp = "^|[А-ЯЁ][а-яё\\s'-]+[А-ЯЁа-яё\\s'-]+$", message = "{middleName.pattern}")
    private String middleName;

    @Size(min = 6, max = 25, message = "{password.size}")
    @NotBlank(message = "{password.netBlank}")
    private String password;

    @Size(min = 6, max = 25, message = "{password.size}")
    @NotBlank(message = "{password.netBlank}")
    private String matchingPassword;

    @Size(min = 5, max = 150, message = "{email.size}")
    @Email(message = "{email.validation}")
    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    @Size(min = 10, message = "{phoneNumber.size}")
    @NotBlank(message = "{phoneNumber.notBlank}")
    @ValidPhoneNumber(message = "{phoneNumber.validPhoneNumber}")
    private String phoneNumber;

//    @Valid
    List<FlatRegDTO> flats = new ArrayList<>();

//    @Valid
    private ContactType contactType;
    //private Boolean boughtParkingPlace;

    private Boolean allowContactsSharing; // Пока бесполезная фигня, но потом прикрутим.

    //private List<String> interestedIn;

    //private String extraInterests;

    //private Integer carsInFamily;

   // private String comments;

}
