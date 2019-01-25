package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "flat")
public class Flat {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contact_flat",
            joinColumns = @JoinColumn(name = "flat_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Collection<Contact> contacts;

    @Column(name = "square")
    private float square;

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "owners_count")
    private int ownersCount;

    @Column(name = "house")
    private int house;

    @Column(name = "porch")
    private int porch;

    @Column(name = "floor")
    private int floor;

    @Column(name = "flat_num")
    private int flatNumber;

    @Column(name = "riser")
    private int riser;

    @Column(name = "house_build")
    private int houseBuild;

    @Column(name = "porch_build")
    private int porchBuild;

    @Column(name = "flat_num_build")
    private int flatNumberBuild;

}
