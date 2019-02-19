package ru.geekbrains.gkportal.dto.interfaces;

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
