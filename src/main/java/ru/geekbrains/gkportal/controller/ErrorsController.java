package ru.geekbrains.gkportal.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static ru.geekbrains.gkportal.config.TemplateNameConst.*;

@Controller
@RequestMapping
public class ErrorsController implements ErrorController {

    private static final Logger logger = Logger.getLogger(ErrorsController.class);

    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {

                if (logger.isDebugEnabled()) {
                    logger.debug("404");
                }
                return returnShablon(model, ERROR_404);
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("500");
                }
                return returnShablon(model, ERROR_500);
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("403");
                }
                return returnShablon(model, ERROR_403);
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("404");
        }
        return returnShablon(model, ERROR_404);
    }
}
