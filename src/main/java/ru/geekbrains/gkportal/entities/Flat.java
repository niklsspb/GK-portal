package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "flat")
public class Flat {
    @Id
    @Column(name = "id")
    private int id;
    private int house;
    private int porch;
    private int floor;
    @Column(name = "flat_num")
    private int flatNum;
    @Column(name = "flat_num_build")
    private int flatNumBuild;
    private Float square;
    @Column(name = "rooms")
    private Integer roomCount;
    @Column(name = "housing_build")
    private Integer buildHousing;
    @Column(name = "porch_build")
    private Integer buildPorch;
    @Column(name = "owners_count")
    private Integer countOwners;
    @Column(name = "riser")
    private int riserNum;
}
