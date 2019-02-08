package ru.geekbrains.gkportal.dto;

import lombok.Data;
import ru.geekbrains.gkportal.entity.OwnershipType;

@Data
public class OwnershipRegDTO {

    private OwnershipType ownershipType;
    private Integer housingNumber;
    private Integer flatNumber;
    private Double square;
    private Integer percentageOfOwner;

}
