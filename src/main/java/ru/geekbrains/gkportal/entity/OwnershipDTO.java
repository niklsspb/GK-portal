package ru.geekbrains.gkportal.entity;

public interface OwnershipDTO {

    String getUuid();

    Integer getHouseNum();

    Integer getHouseBuildNum();

    String getNumber();

    String getBuildNumber();

    Float getSquare();

    Integer getPercentageOfOwner();

    OwnershipTypeDTO getOwnershipType();

}
