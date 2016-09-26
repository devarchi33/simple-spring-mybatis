package com.devarchi33.config;

import com.devarchi33.security.JscanAuthenticationEntryPoint;
import com.devarchi33.security.JscanAuthenticationFailureHandler;
import com.devarchi33.security.JscanAuthenticationSuccessHandler;
import com.devarchi33.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * Created by donghoon on 2016. 9. 26..
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    private final String LOGIN_FORM = "/loginForm";

    private final String[] UNSECURED_RESOURCE_LIST = new String[]{"/static/**"};
    private final String[] UNAUTHORIZED_RESOURCE_LIST = new String[]{"/", LOGIN_FORM};

    @Deprecated
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
                .ignoring().antMatchers(UNSECURED_RESOURCE_LIST);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(UNAUTHORIZED_RESOURCE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity
                .formLogin()
                .loginPage(LOGIN_FORM)
                .loginProcessingUrl("/login")
                .failureUrl(LOGIN_FORM + "?error")
                .defaultSuccessUrl("/dashboard/security", true)
                .successHandler(authenticationSuccessHandler())
                .usernameParameter("loginId")
                .passwordParameter("password")
                .permitAll();
        httpSecurity
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl(LOGIN_FORM)
                .permitAll();
        httpSecurity.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
        httpSecurity.requestCache().requestCache(nullRequestCache());
        httpSecurity.httpBasic();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JscanAuthenticationEntryPoint(LOGIN_FORM);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new JscanAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new JscanAuthenticationFailureHandler(LOGIN_FORM);
    }

    @Bean
    public NullRequestCache nullRequestCache() {
        return new NullRequestCache();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
