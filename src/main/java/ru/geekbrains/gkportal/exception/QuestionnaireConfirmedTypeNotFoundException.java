package ru.geekbrains.gkportal.exception;

import java.util.NoSuchElementException;

public class QuestionnaireConfirmedTypeNotFoundException extends NoSuchElementException {

    private final static String MESSAGE = "QuestionnaireContactConfirm with uuid=%s not found";

    public QuestionnaireConfirmedTypeNotFoundException(String uuid) {
        super(String.format(MESSAGE, uuid));
    }

}
