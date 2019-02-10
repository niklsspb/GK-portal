package ru.geekbrains.gkportal.dto;

import lombok.Data;
import ru.geekbrains.gkportal.entity.OwnershipType;

@Data
public class OwnershipRegDTO {

    private OwnershipType ownershipType;
    private String ownershipTypeError;
    private Integer housingNumber;
    private String housingNumberError;
    private String flatNumber;
    private String flatNumberError;
    private String square;
    private String squareError;
    private Integer percentageOfOwner;
    private String percentageOfOwnerError;
    private boolean hasError;

}
