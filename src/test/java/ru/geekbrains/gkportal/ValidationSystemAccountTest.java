package ru.geekbrains.gkportal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.geekbrains.gkportal.entities.SystemAccount;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import java.util.Set;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ValidationSystemAccountTest {

    private Validator validator;
    private SystemAccount systemAccount;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        systemAccount = new SystemAccount();
        systemAccount.setFirstName("test");
        systemAccount.setLastName("test");
        systemAccount.setMiddleName("test");
        systemAccount.setEmail("test@mail.ru");
        systemAccount.setFlatNumber(1);
        systemAccount.setFloorNumber(1);
        systemAccount.setHousingNumber(1);
        systemAccount.setLogin("mytest");
        systemAccount.setPassword("123456");
        systemAccount.setMatchingPassword("123456");
        systemAccount.setPhoneNumber("1234567890");
        systemAccount.setPorchNumber(1);
    }

    @Test
    public void ValidationSuccessSystemAccountTest() throws Exception {
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertTrue(violations.isEmpty());
        System.out.println(violations);
    }

    @Test
    public void ValidationNameFailedSystemAccountTest() throws Exception {
        systemAccount.setFirstName("");
        systemAccount.setLastName("");
        systemAccount.setMiddleName("");
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertEquals( 3, violations.size());
        Assert.assertEquals(
                "недопустимое количество символов",
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void ValidationEmailFailedSystemAccountTest() throws Exception {
        systemAccount.setEmail("testmail.ru");
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertEquals( 1, violations.size());
        Assert.assertEquals(
                "Не верно указан email",
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void ValidationPhoneFailedSystemAccountTest() throws Exception {
        systemAccount.setPhoneNumber("dcdsf434546");
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertEquals( 1, violations.size());
        Assert.assertEquals(
                "Не верно указан телефонный номер",
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void ValidationPasswordMathFailedSystemAccountTest() throws Exception {
        systemAccount.setPassword("123456");
        systemAccount.setMatchingPassword("654321");
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertEquals( 1, violations.size());
        Assert.assertEquals(
                "Значения полей пароль и пароль подтверждение должны совпадать",
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void ValidationEmptyFailedSystemAccountTest() throws Exception {
        systemAccount.setFirstName(null);
        systemAccount.setLastName(null);
        systemAccount.setMiddleName(null);
        systemAccount.setFlatNumber(null);
        systemAccount.setFloorNumber(null);
        systemAccount.setHousingNumber(null);
        systemAccount.setLogin(null);
        systemAccount.setPassword(null);
        systemAccount.setMatchingPassword(null);
        systemAccount.setPorchNumber(null);
        Set<ConstraintViolation<SystemAccount>> violations = validator.validate(systemAccount);
        Assert.assertEquals( 10, violations.size());
        Assert.assertEquals(
                "не может принимать пустое значение",
                violations.iterator().next().getMessage()
        );
    }

}


