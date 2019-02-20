package ru.geekbrains.gkportal.validation;

import org.apache.log4j.Logger;

import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;


public class ValidatorUtil {

    private static final Logger logger = Logger.getLogger(ValidatorUtil.class);

    public static void addValidationError(String field, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addNode(field)
                .addConstraintViolation();
    }

    public static Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field f = object.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(object);
    }
}