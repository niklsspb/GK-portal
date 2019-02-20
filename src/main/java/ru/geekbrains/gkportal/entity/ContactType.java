package ru.geekbrains.gkportal.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity(name = "contact_type")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContactType extends AbstractEntity {

    @Column(name = "description")
    @NotBlank(message = "Тип контакта должен быть заполнен.")
    private String description;
}
