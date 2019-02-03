package ru.geekbrains.gkportal.entities;


import lombok.Data;
import org.hibernate.validator.constraints.Range;
import ru.geekbrains.gkportal.validation.PasswordsNotEqual;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@PasswordsNotEqual(passwordFieldName = "password", passwordVerificationFieldName = "matchingPassword", message = "Значения полей пароль и пароль подтверждение должны совпадать")
public class SystemAccount {
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 2, max = 25, message = "недопустимое количество символов")
    private String firstName;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 2, max = 25, message = "недопустимое количество символов")
    private String lastName;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 0, max = 25, message = "недопустимое количество символов")
    private String middleName;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 3, max=25, message = "недопустимое количество символов")
    private String login;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 6, max=25, message = "недопустимое количество символов")
    private String password;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 6, max=25, message = "недопустимое количество символов")
    private String matchingPassword;

    @Email
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 3, max=25, message = "недопустимое количество символов")
    private String email;

    @ValidPhoneNumber
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 10, message = "требуется минимум 10 символов")
    private String phoneNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Range(min = 1, max = 999, message = "значение должно быть в пределах от 1-999")
    private Integer housingNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Range(min = 1, max = 200, message = "значение должно быть в пределах от 1-200")
    private Integer porchNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Range(min = 1, max = 999, message = "значение должно быть в пределах от 1-999")
    private Integer floorNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Range(min = 1, max = 9999, message = "значение должно быть в пределах от 1-9999")
    private Integer flatNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Range(min = 1, max = 20, message = "значение должно быть в пределах от 1-20")
    private Integer roomCount;

    private ContactType contactType;
    //private Boolean boughtParkingPlace;

    private Boolean allowContactsSharing; // Пока бесполезная фигня, но потом прикрутим.

    //private List<String> interestedIn;

    //private String extraInterests;

    //private Integer carsInFamily;

   // private String comments;




    public SystemAccount() {

    }
}
