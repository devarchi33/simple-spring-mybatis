package com.devarchi33.controller;

import com.devarchi33.domain.UserInfo;
import com.devarchi33.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    private PasswordEncoder encoder;
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

            // spring security 적용에 따른 password encoding.
            user.setPassword(encoder.encode(user.getPassword()));
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

}