package ru.geekbrains.gkportal.entity.questionnaire;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import ru.geekbrains.gkportal.entities.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Yuriy Tilman
 */

@Data
@Entity(name = "real_estate")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RealEstate extends AbstractEntity { // TODO: 05.02.19

    @Column(name = "flats")
    @NotNull(message = "Couldn't be empty!")
    private boolean flats;

    @Column(name = "commercial")
    @NotNull(message = "Couldn't be empty!")
    private boolean commercial;

    @Column(name = "parking")
    @NotNull(message = "Couldn't be empty!")
    private boolean parking;

    @Column(name = "build_num")
    @NotNull(message = "Couldn't be empty!")
    private boolean build_num;

    @Column(name = "house_num")
    private Integer houseNum;

    @Column(name = "house_build_num")
    private Integer houseBuildNum;

    @Column(name = "number")
    private Integer number;

    @Column(name = "build_number")
    private Integer buildNumber;

    @Column(name = "square")
    @NotNull(message = "Couldn't be empty!")
    private Double square;

    @Column(name = "percentage_of_owner")
    @NotNull(message = "Couldn't be empty!")
    @ColumnDefault(value = "100")
    private Integer percentageOfOwner;


}
