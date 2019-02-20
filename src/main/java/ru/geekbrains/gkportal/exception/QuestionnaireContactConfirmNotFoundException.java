package ru.geekbrains.gkportal.exception;

import java.util.NoSuchElementException;

public class QuestionnaireContactConfirmNotFoundException extends NoSuchElementException {

    private final static String MESSAGE = "QuestionnaireConfirmedType with uuid=%s not found";

    public QuestionnaireContactConfirmNotFoundException(String uuid) {
        super(String.format(MESSAGE, uuid));
    }

}
