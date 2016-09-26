package com.devarchi33.controller;

import com.devarchi33.domain.UserInfo;
import com.devarchi33.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by donghoon on 15. 8. 22..
 * Modified by donghoon on 16. 9. 26..
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final String ACTIVE = "active";

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserInfo constructor() {
        return new UserInfo();
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("message", "This is devarchi33_test registration form made with Bootstrap.");

        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpProc(@ModelAttribute("user") UserInfo user) {
        ModelAndView mv;
        UserInfo findUser = userService.findUserByEmail(user.getEmail());

        if (findUser != null) {
            mv = new ModelAndView("signUp");
            mv.addObject("message", "이미 가입된 이메일 입니다.");

            return mv;
        } else {
            userService.signUpUser(user);
            mv = new ModelAndView("login");
            mv.addObject("message2", user.getEmail() + ", 님의 회원가입이 완료되었습니다.");

            return mv;
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("message", "Login Form :)");

        return mv;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView excuteLogin(@RequestParam("userId") String form_email,
                                    @RequestParam("password") String form_password) {

        logger.info("input email : {}, input password : {} ", form_email, form_password);

        ModelAndView mv = new ModelAndView();

        UserDetails userDetails = userService.loadUserByUsername(form_email);

        // TODO: 2016. 9. 26. 로직수정. 
        if (userDetails.isCredentialsNonExpired()) {
            logger.info("login success");
            mv.setViewName("main");
            mv.addObject("page", "home");
            mv.addObject("homeActive", ACTIVE);
            mv.addObject("title", "Home");
        } else {
            logger.debug("login fail");
            mv.addObject("message2", "이메일 또는 패스워드를 확인해주세요.");
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ModelAndView logout() {
        return login();
    }

}