package com.devarchi33.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by donghoon on 2016. 9. 1..
 */
@Component
public class JscanAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        String retUrl = httpServletRequest.getParameter("returl");
        String csrfToken = httpServletRequest.getParameter("_csrf");
        logger.debug("CSRF Token: {}", csrfToken);

        if (retUrl == null || retUrl.isEmpty()) {

            // TODO: 2016. 9. 26. 최초 로그인 패스 지정하기.
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "??");
            return;
        }

        httpServletResponse.sendRedirect(retUrl);
    }
}
