package ru.geekbrains.gkportal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity(name = "ownership_type")
@EqualsAndHashCode(callSuper = true)
public class OwnershipType extends AbstractEntity {

    @Column(name = "description")
    @NotNull(message = "Поле не должно быть пустым!")
    private String description;

    @Column(name = "name")
    @NotNull(message = "Поле не должно быть пустым!")
    private String name;

    @Column(name = "is_req_house_num")
    @NotNull(message = "Поле не должно быть пустым!")
    private boolean isRequedHouseNumber;

    @Column(name = "is_req_percentage_owner")
    @NotNull(message = "Поле не должно быть пустым!")
    private boolean isRequedPercentageOwner;

    @Column(name = "is_req_square")
    @NotNull(message = "Поле не должно быть пустым!")
    private boolean isRequedSquare;
    @Column(name = "is_use_on_questionnaire")
    @NotNull(message = "Поле не должно быть пустым!")
    private boolean isUseInQuestionnaire;
}
