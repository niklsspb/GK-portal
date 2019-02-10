package ru.geekbrains.gkportal.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Yuriy Tilman
 */

//todo Переделать многие к многим, у связки тип собственности и доля


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ownership")
@ToString(exclude = "contact")
@EqualsAndHashCode(callSuper = true, exclude = "contact")
public class Ownership extends AbstractEntity { // TODO: 05.02.19

    @ManyToOne
    @JoinColumn(name = "ownership_type_id")
    @NotNull(message = "Тип должен быть указан!")
    private OwnershipType ownershipType;

    @Column(name = "is_build_num")
    @NotNull(message = "Поле не должно быть пустым!")
    private boolean is_build_num;

    @Column(name = "house_num")
    private Integer houseNum;

    @Column(name = "house_build_num")
    private Integer houseBuildNum;

    @Column(name = "number")
    private String number;

    @Column(name = "build_number")
    private String buildNumber;

    @Column(name = "square")
    private Float square;

    @Column(name = "percentage_of_owner")
    @ColumnDefault(value = "100")
    private Integer percentageOfOwner;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @NotNull(message = "Contact s.b. selected!")
    private Contact contact;

}
