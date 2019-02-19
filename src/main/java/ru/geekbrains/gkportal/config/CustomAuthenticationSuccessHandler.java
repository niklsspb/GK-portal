package ru.geekbrains.gkportal.config;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess
            (
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Authentication authentication
            ) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        if (session != null) {
            String redirectUrl = (String) session.getAttribute("url_prior_login");
            if (logger.isDebugEnabled()){
                logger.debug("redirectUrl: " + redirectUrl);
            }
            if (redirectUrl != null) {
                session.removeAttribute("url_prior_login");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
                if (logger.isDebugEnabled()){
                    logger.debug("Session removeAttribute url_prior_login");
                }
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
                if (logger.isDebugEnabled()){
                    logger.debug("Authentication success");
                }
            }

        } else {
            super.onAuthenticationSuccess(request, response, authentication);
            if (logger.isDebugEnabled()){
                logger.debug("Authentication success");
            }
        }
    }
}
