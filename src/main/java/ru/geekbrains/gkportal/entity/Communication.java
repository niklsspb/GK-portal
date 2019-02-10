package ru.geekbrains.gkportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "communication")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contact")
@EqualsAndHashCode(exclude = "contact", callSuper = true)
public class Communication extends AbstractEntity {

//    TODO: Кто будет тестить сущности раскоментируйте аннотацию @Valid и посмотрите работает ли,
//     просто может не правильно валидироваться объект, я пока не понял в чем глюк, работаю.
//    @Valid
    @NotNull(message = "Вид связи должен быть выбран.")
    @ManyToOne
    @JoinColumn(name = "communication_type_id")
    private CommunicationType communicationType;

//    @Valid
    @NotNull(message = "Контактное лицо должно быть выбрано.")
    @ManyToOne
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private Contact contact;

    @Column(name = "identify")
    @Size(
            min = 3, //TODO: Решить про длинну идентификатора пока min=3 символа
            message = "Идентификатор ${validatedValue} должен быть более {min} символов."
    )
    //TODO: Решил пока оставить, надо посмотреть как реагирует на пробелы к примеру 4 штуки
    @NotBlank(message = "Идентификатор не должен быть пустым.")
    private String identify;

    //TODO: все-таки прийти к единому мнению что это? из описания базы 'описание - типа домашняя почта'
    @Column(name = "description")
    @NotNull(message = "Couldn't be empty!")
    private String description;

    @Column(name = "confirmed")
    @NotNull(message = "Couldn't be empty!")
    private boolean confirmed;

    @Column(name = "confirm_code_date")
    @UpdateTimestamp
//    @NotNull(message = "Couldn't be empty!")a
    private LocalDateTime confirmCodeDate;
    // TODO: 05.02.19 вынести в QuestionnaireContactConfirm

    @Column(name = "confirm_code")
    private String confirmCode;

}
