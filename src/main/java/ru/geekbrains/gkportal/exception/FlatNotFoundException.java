package ru.geekbrains.gkportal.exception;

import org.apache.log4j.Logger;
import ru.geekbrains.gkportal.dto.FlatRegDTO;
import ru.geekbrains.gkportal.entity.Flat;

import java.util.NoSuchElementException;

public class FlatNotFoundException extends NoSuchElementException {

    private static final Logger logger = Logger.getLogger(FlatNotFoundException.class);

    private final static String MESSAGE = "House %d, Porch %d, Floor %d, Flat %d not found";

    public FlatNotFoundException(Flat flat) {
        super(String.format(MESSAGE,
                flat.getHouse(),
                flat.getPorch(),
                flat.getFloor(),
                flat.getFlatNumber())
        );
    }

    public FlatNotFoundException(FlatRegDTO flatRegDTO) {
        super(String.format(MESSAGE,
                flatRegDTO.getHousingNumber(),
                flatRegDTO.getPorchNumber(),
                flatRegDTO.getFloorNumber(),
                flatRegDTO.getFlatNumber())
        );
    }

}
