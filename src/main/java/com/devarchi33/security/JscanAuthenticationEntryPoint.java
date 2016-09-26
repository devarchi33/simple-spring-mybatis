package com.devarchi33.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by donghoon on 2016. 9. 1..
 */
public class JscanAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private String LOGIN_FORM;

    public JscanAuthenticationEntryPoint(String LOGIN_FORM) {
        this.LOGIN_FORM = LOGIN_FORM;
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String redirectUrl = UrlUtils.buildRequestUrl(httpServletRequest);
        String encoded = httpServletResponse.encodeRedirectURL(redirectUrl);

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_FORM + "?returl=" + encoded);
    }
}
