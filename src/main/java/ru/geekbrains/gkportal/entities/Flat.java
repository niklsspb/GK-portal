package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "flats")
public class Flat {
    @Id
    @Column(name = "flat_id")
    private int id;
    private int housing;
    private int porch;
    private int floor;
    private int flat;
    @Column(name = "flat_build")
    private int flatBuild;
    private Float square;
    @Column(name = "room_count")
    private Integer roomCount;
    @Column(name = "housing_build")
    private Integer buildHousing;
    @Column(name = "porch_build")
    private Integer buildPorch;
    @Column(name = "owners_count")
    private Integer countOwners;
    @Column(name = "riser_num")
    private int riserNum;
}
