package ru.geekbrains.gkportal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

    public Flat() {
    }

    public Integer getBuildHousing() {
        return buildHousing;
    }

    public void setBuildHousing(Integer buildHousing) {
        this.buildHousing = buildHousing;
    }

    public Integer getBuildPorch() {
        return buildPorch;
    }

    public void setBuildPorch(Integer buildPorch) {
        this.buildPorch = buildPorch;
    }

    public Integer getCountOwners() {
        return countOwners;
    }

    public void setCountOwners(Integer countOwners) {
        this.countOwners = countOwners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHousing() {
        return housing;
    }

    public void setHousing(int housing) {
        this.housing = housing;
    }

    public int getPorch() {
        return porch;
    }

    public void setPorch(int porch) {
        this.porch = porch;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getFlatBuild() {
        return flatBuild;
    }

    public void setFlatBuild(int flatBuild) {
        this.flatBuild = flatBuild;
    }

    public Float getSquare() {
        return square;
    }

    public void setSquare(Float square) {
        this.square = square;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }
}
