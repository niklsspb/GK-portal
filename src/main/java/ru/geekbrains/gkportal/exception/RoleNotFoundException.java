package ru.geekbrains.gkportal.exception;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;

public class RoleNotFoundException extends NoSuchElementException {

    private static final Logger logger = Logger.getLogger(RoleNotFoundException.class);

    private final static String MESSAGE = "Description %s not found";

    public RoleNotFoundException(String description) {
        super(String.format(MESSAGE, description));
    }

}
