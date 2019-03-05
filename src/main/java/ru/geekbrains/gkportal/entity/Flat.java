package ru.geekbrains.gkportal.entity;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@Getter
@Setter
@Entity(name = "flat")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Flat extends AbstractEntity {
//    @Valid
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contact_flat",
            joinColumns = @JoinColumn(name = "flat_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Collection<Contact> contacts;

    @Column(name = "square")
    @Positive
    private Float square;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "owners_count")
    @PositiveOrZero //TODO: надо точно знать может ли быть 0 жильцов
    private Integer ownersCount;

    @Column(name = "house")
    @NotNull(message = "Номер дома необходим.")
    @Positive
    private Integer house;

    @Column(name = "porch")
    @NotNull(message = "Номер подъезда необходим.")
    @Positive
    private Integer porch;

    @Column(name = "floor")
    @NotNull(message = "Номер этажа необходим.")
    @Positive
    private Integer floor;

    @Column(name = "flat_num")
    @NotNull(message = "Номер квартиры необходим.")
    @Positive //TODO: надо сделать проверку номеров квартир по подъездам
    private Integer flatNumber;

    @Column(name = "riser")
    @NotNull(message = "Номер стояка необходим.")
    @Positive
    private Integer riser;

    @Column(name = "house_build")
    @NotNull(message = "Строительный номер дома необходим.")
    @Positive
    private Integer houseBuild;

    @Column(name = "porch_build")
    @NotNull(message = "Строительный номер подъезда необходим.")
    @Positive
    private Integer porchBuild;

    @Column(name = "flat_num_build")
    @NotNull(message = "Строительный номер квартиры необходим.")
    @Positive
    private Integer flatNumberBuild;

    @Formula("(SELECT count(*) FROM contact_flat cf WHERE cf.flat_id=id)")
    private Integer accountCount;
}
