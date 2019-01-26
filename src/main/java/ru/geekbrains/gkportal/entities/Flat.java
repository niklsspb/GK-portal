package ru.geekbrains.gkportal.entities;

import javafx.beans.binding.IntegerBinding;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "flat")
public class Flat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    private Integer house;

    @Column(name = "porch")
    private Integer porch;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "flat_num")
    private Integer flatNumber;

    @Column(name = "riser")
    private Integer riser;

    @Column(name = "house_build")
    private Integer houseBuild;

    @Column(name = "porch_build")
    private Integer porchBuild;

    @Column(name = "flat_num_build")
    private Integer flatNumberBuild;

}
