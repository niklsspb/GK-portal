package ru.geekbrains.gkportal.exception;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;

public class CommunicationTypeNotFoundException extends NoSuchElementException {

    private static final Logger logger = Logger.getLogger(CommunicationTypeNotFoundException.class);

    private final static String MESSAGE = "Description %s not found";

    public CommunicationTypeNotFoundException(String description) {
        super(String.format(MESSAGE, description));
    }

}
