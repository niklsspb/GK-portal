package ru.geekbrains.gkportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.gkportal.validation.ValidPhoneNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractSystemAccount {

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
//    @Email(message = "{email.validation}")
    @NotEmpty(message = "{email.notEmpty}")
//    special thanks to: http://emailregex.com/ for email pattern
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
            "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
            "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?" +
            "|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?" +
            "|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]" +
            "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "{email.validation}")
    private String email;

    @Size(min = 10, max = 15, message = "{phoneNumber.size}")
    @NotBlank(message = "{phoneNumber.notBlank}")
    @ValidPhoneNumber(message = "{phoneNumber.validPhoneNumber}")
    private String phoneNumber;

}
