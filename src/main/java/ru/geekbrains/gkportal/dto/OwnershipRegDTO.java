package ru.geekbrains.gkportal.dto;

import lombok.Data;
import ru.geekbrains.gkportal.entity.OwnershipType;

@Data
public class OwnershipRegDTO {

    private OwnershipType ownershipType;
    private Integer housingNumber;
    private String flatNumber;
    private Double square;
    private Integer percentageOfOwner;

}
