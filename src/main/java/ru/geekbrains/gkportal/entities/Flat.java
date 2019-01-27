package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data
@Table(name = "flat")
public class Flat {

    @Id
    @Column(name = "id")
    private String id;

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
    private int house;

    @Column(name = "porch")
    @NotNull(message = "Couldn't be empty!")
    private int porch;

    @Column(name = "floor")
    @NotNull(message = "Couldn't be empty!")
    private int floor;

    @Column(name = "flat_num")
    @NotNull(message = "Couldn't be empty!")
    private int flatNumber;

    @Column(name = "riser")
    @NotNull(message = "Couldn't be empty!")
    private int riser;

    @Column(name = "house_build")
    @NotNull(message = "Couldn't be empty!")
    private int houseBuild;

    @Column(name = "porch_build")
    @NotNull(message = "Couldn't be empty!")
    private int porchBuild;

    @Column(name = "flat_num_build")
    @NotNull(message = "Couldn't be empty!")
    private int flatNumberBuild;

}
