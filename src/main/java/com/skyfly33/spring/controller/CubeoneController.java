package com.skyfly33.spring.controller;

import com.skyfly33.spring.domain.User;
import com.skyfly33.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Controller
@RequestMapping("/")
public class CubeoneController {

    Logger logger = LoggerFactory.getLogger(CubeoneController.class);

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User constructor() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", "Login Form :)");
        return mv;
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public ModelAndView mainView() {
        ModelAndView mv = new ModelAndView("main");
        return mv;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView excuteLogin(HttpServletRequest request,
                                    @ModelAttribute("User") User user,
                                    @RequestParam("form-email") String form_email,
                                    @RequestParam("form-password") String form_password) {
        logger.info("input email : " + form_email);
        logger.info("input password : " + form_password);

        ModelAndView mv = new ModelAndView();

        user.setEmail(form_email);
        user.setPassword(form_password);
        user.setPhone(userService.findUserByEmail(form_email).getPhone());

        if (userService.isValidUser(user)) {
            mv.addObject("loginEmail", form_email);
            mv.setViewName("main");
        } else {
            mv.addObject("inValidUser", "please check login info...");
            mv.setViewName("hello");
        }


        mv.addObject("pass", user.getPassword());
        mv.addObject("phone", user.getPhone());
        logger.info("phone" + user.getPhone());

        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView("contents/signUp");
        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpProc(@ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("contents/signUp");
        userService.signUpUser(user);
        return mv;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView RuntimeExceptionHandler() {
        ModelAndView mv = new ModelAndView("error/errorRuntimeException");
        return mv;
    }
}