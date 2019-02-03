package ru.geekbrains.gkportal.entities;


import lombok.Data;
import ru.geekbrains.gkportal.validation.FieldMatch;
import ru.geekbrains.gkportal.validation.ValidEmail;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@FieldMatch(first = "password", second = "matchingPassword", message = "Значения полей пароль и пароль подтверждение должны совпадать")
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

    @ValidEmail
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 3, max=25, message = "недопустимое количество символов")
    private String email;

    @ValidPhoneNumber
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 10, message = "требуется минимум 10 символов")
    private String phoneNumber;

    @NotNull(message = "не может принимать пустое значение")
    //@Pattern(regexp = "^[0-9]{1,3}", message = "требуется от 1 до 3-х цифровых символов")
    @Min(value = 1, message = "минимальное значение 1")
    private Integer housingNumber;

    @NotNull(message = "не может принимать пустое значение")
    //@Pattern(regexp = "^[0-9]{1,2}", message = "требуется от 1 до 2-х цифровых символов")
    @Min(value = 1, message = "минимальное значение 1")
    private Integer porchNumber;

    @NotNull(message = "не может принимать пустое значение")
   // @Pattern(regexp = "^[0-9]{1,2}", message = "требуется от 1 до 2-х цифровых символов")
    @Min(value = 1, message = "минимальное значение 1")
    private Integer floorNumber;

    @NotNull(message = "не может принимать пустое значение")
    //@Pattern(regexp = "^[0-9]{1,4}", message = "требуется от 1 до 4-х цифровых символов")
    @Min(value = 1, message = "минимальное значение 1")
    private Integer flatNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Min(value = 1, message = "минимальное значение 1")
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
