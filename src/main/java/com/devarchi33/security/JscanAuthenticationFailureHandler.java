package com.devarchi33.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by donghoon on 2016. 9. 1..
 */
public class JscanAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String LOGIN_FORM;

    public JscanAuthenticationFailureHandler(String LOGIN_FORM) {
        this.LOGIN_FORM = LOGIN_FORM;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletRequest.getRequestDispatcher("").forward(httpServletRequest, httpServletResponse);
    }
}
