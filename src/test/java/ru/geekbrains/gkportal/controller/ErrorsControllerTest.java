package ru.geekbrains.gkportal.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.RequestDispatcher;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static ru.geekbrains.gkportal.config.TemplateNameConst.*;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest

public class ErrorsControllerTest {
    private static final Map<String, String> myMap = new HashMap<String, String>() {{
        put("404", ERROR_404);
        put("500", ERROR_500);
        put("403", ERROR_403);
    }};
    private ErrorsController errorsController;

    @Autowired
    public void setErrorsController(ErrorsController errorsController) {
        this.errorsController = errorsController;
    }

    @Test
    public void handleErrorTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse rer;


        for (Map.Entry<String, String> m : myMap.entrySet()) {
            request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, m.getKey());
            assertEquals(
                    errorsController.handleError(request, null),
                    m.getValue()
            );
            request.clearAttributes();
        }
    }
}
