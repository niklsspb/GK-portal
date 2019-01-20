package ru.geekbrains.gkportal.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "build_porch_config")
@IdClass(BuildPorchConfig.HousingPorchID.class)
public class BuildPorchConfig {
    @Id
    @Column(name = "housing")
    private int housingID;
    @Id
    @Column(name = "porch")
    private int porchID;
    @Column(name = "floors_count")
    private int floorsCount;
    @Column(name = "flat_quantity_floor")
    private int flatCountOnFloor;
    @Column(name = "flat_from_floor")
    private int flatStartFromFloor;
    @Column(name = "flat_quantity_start_floor")
    private int flatCountOnStartFloor;
    @Column(name = "record_builded")
    private boolean purchUsed;
    @Column(name = "porch_num_from_right")
    private boolean porchNumFromRight;
    @Column(name = "housing_num_from_right")
    private boolean housingNumFromRight;
    @Column(name = "all_flat_count")
    private int flatOnPorchCount;
    @Column(name = "ident_flat_count")
    private int flatOnPorchIdentCount;
    @Column(name = "build_housing")
    private int buildHousing;
    @Column(name = "build_porch")
    private int buildPorch;

    public int getHousingID() {
        return housingID;
    }

    public void setHousingID(int housingID) {
        this.housingID = housingID;
    }

    public int getBuildHousing() {
        return buildHousing;
    }

    public void setBuildHousing(int buildHousing) {
        this.buildHousing = buildHousing;
    }

    public int getBuildPorch() {
        return buildPorch;
    }

    public void setBuildPorch(int buildPorch) {
        this.buildPorch = buildPorch;
    }

    public int getPorchID() {
        return porchID;
    }

    public void setPorchID(int porchID) {
        this.porchID = porchID;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    public void setFloorsCount(int floorsCount) {
        this.floorsCount = floorsCount;
    }

    public int getFlatCountOnFloor() {
        return flatCountOnFloor;
    }

    public void setFlatCountOnFloor(int flatCountOnFloor) {
        this.flatCountOnFloor = flatCountOnFloor;
    }

    public int getFlatStartFromFloor() {
        return flatStartFromFloor;
    }

    public void setFlatStartFromFloor(int flatStartFromFloor) {
        this.flatStartFromFloor = flatStartFromFloor;
    }

    public int getFlatCountOnStartFloor() {
        return flatCountOnStartFloor;
    }

    public void setFlatCountOnStartFloor(int flatCountOnStartFloor) {
        this.flatCountOnStartFloor = flatCountOnStartFloor;
    }

    public boolean isPurchUsed() {
        return purchUsed;
    }

    public void setPurchUsed(boolean purchUsed) {
        this.purchUsed = purchUsed;
    }

    public boolean isPorchNumFromRight() {
        return porchNumFromRight;
    }

    public void setPorchNumFromRight(boolean porchNumFromRight) {
        this.porchNumFromRight = porchNumFromRight;
    }

    public boolean isHousingNumFromRight() {
        return housingNumFromRight;
    }

    public void setHousingNumFromRight(boolean housingNumFromRight) {
        this.housingNumFromRight = housingNumFromRight;
    }

    public int getFlatOnPorchCount() {
        return flatOnPorchCount;
    }

    public void setFlatOnPorchCount(int flatOnPorchCount) {
        this.flatOnPorchCount = flatOnPorchCount;
    }

    public int getFlatOnPorchIdentCount() {
        return flatOnPorchIdentCount;
    }

    public void setFlatOnPorchIdentCount(int flatOnPorchIdentCount) {
        this.flatOnPorchIdentCount = flatOnPorchIdentCount;
    }

    @Embeddable
    public static class HousingPorchID implements Serializable {
        protected Integer housingID;
        protected Integer porchID;

        public HousingPorchID() {
        }

        public HousingPorchID(Integer housingID, Integer porchID) {
            this.housingID = housingID;
            this.porchID = porchID;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HousingPorchID otherId = (HousingPorchID) o;
            if (!housingID.equals(otherId.housingID)) return false;
            return porchID.equals(otherId.porchID);
        }

        @Override
        public int hashCode() {
            int result = housingID.hashCode();
            result = 31 * result + porchID.hashCode();
            return result;
        }
    }

}
