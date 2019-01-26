package ru.geekbrains.gkportal.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
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

    @Column(name = "record_built")
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
