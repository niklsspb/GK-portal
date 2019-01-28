package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@Table(name = "flat")
public class Flat {

    @Id
    @Column(name = "id")
    private String uuid;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contact_flat",
            joinColumns = @JoinColumn(name = "flat_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Collection<Contact> contacts;

    @Column(name = "square")
    private Float square;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "owners_count")
    private Integer ownersCount;

    @Column(name = "house")
    @NotNull(message = "Couldn't be empty!")
    private Integer house;

    @Column(name = "porch")
    @NotNull(message = "Couldn't be empty!")
    private Integer porch;

    @Column(name = "floor")
    @NotNull(message = "Couldn't be empty!")
    private Integer floor;

    @Column(name = "flat_num")
    @NotNull(message = "Couldn't be empty!")
    private Integer flatNumber;

    @Column(name = "riser")
    @NotNull(message = "Couldn't be empty!")
    private Integer riser;

    @Column(name = "house_build")
    @NotNull(message = "Couldn't be empty!")
    private Integer houseBuild;

    @Column(name = "porch_build")
    @NotNull(message = "Couldn't be empty!")
    private Integer porchBuild;

    @Column(name = "flat_num_build")
    @NotNull(message = "Couldn't be empty!")
    private Integer flatNumberBuild;

    public Flat() {
    }
}
