package ru.geekbrains.gkportal.exception;

import ru.geekbrains.gkportal.entity.Flat;
import ru.geekbrains.gkportal.entity.SystemAccount;

import java.util.NoSuchElementException;

public class FlatNotFoundException extends NoSuchElementException {

    private final static String MESSAGE = "House %d, Porch %d, Floor %d, Flat %d not found";

    public FlatNotFoundException(Flat flat) {
        super(String.format(MESSAGE,
                flat.getHouse(),
                flat.getPorch(),
                flat.getFloor(),
                flat.getFlatNumber())
        );
    }

    public FlatNotFoundException(SystemAccount systemAccount) {
        super(String.format(MESSAGE,
                systemAccount.getHousingNumber(),
                systemAccount.getPorchNumber(),
                systemAccount.getFloorNumber(),
                systemAccount.getFlatNumber())
        );
    }

}
