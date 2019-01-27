package ru.geekbrains.gkportal.entities;


import lombok.Data;
import ru.geekbrains.gkportal.validation.FieldMatch;
import ru.geekbrains.gkportal.validation.ValidEmail;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@FieldMatch(first = "password", second = "matchingPassword", message = "Значения полей пароль и пароль подтверждение должны совпадать")
public class SystemUser {
    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 1, max=25, message = "недопустимое количество символов")
    private String firstName;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 1, max=25, message = "недопустимое количество символов")
    private String lastName;

    @NotNull(message = "не может принимать пустое значение")
    @Size(min = 1, max=25, message = "недопустимое количество символов")
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
    @Pattern(regexp = "^[0-9]{1,3}", message = "требуется от 1 до 3-х цифровых символов")
    private int housingNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Pattern(regexp = "^[0-9]{1,2}", message = "требуется от 1 до 2-х цифровых символов")
    private int porchNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Pattern(regexp = "^[0-9]{1,2}", message = "требуется от 1 до 2-х цифровых символов")
    private int floorNumber;

    @NotNull(message = "не может принимать пустое значение")
    @Pattern(regexp = "^[0-9]{1,4}", message = "требуется от 1 до 4-х цифровых символов")
    private int flatNumber;

    private String comments;

    public SystemUser() {

    }
}
