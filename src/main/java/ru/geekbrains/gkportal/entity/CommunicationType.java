package ru.geekbrains.gkportal.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity(name = "communication_type")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommunicationType extends AbstractEntity {

    @Column(name = "description")
    @NotBlank(message = "Тип связи должен быть задан.")
    private String description;
}
