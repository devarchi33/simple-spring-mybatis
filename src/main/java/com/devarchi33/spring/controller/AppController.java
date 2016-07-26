package com.devarchi33.spring.controller;

import com.devarchi33.spring.service.UserService;
import com.devarchi33.spring.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Controller
@RequestMapping("/")
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User constructor() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("message", "Login Form :)");
        return mv;
    }

//    @RequestMapping(value = "main", method = RequestMethod.POST)
//    public ModelAndView main(@RequestParam("userThumb") String userThumb,
//                             @RequestParam("kakaoNickName") String kakaoNickName) {
//        ModelAndView mv = new ModelAndView("main");
//        logger.info("Thumbnail url : " + userThumb);
//        logger.info("kakaoNickName : " + kakaoNickName);
//        this.thumbnailImg = userThumb;
//        this.kakaoNickName = kakaoNickName;
//        mv.addObject("thumbnail", this.thumbnailImg);
//        mv.addObject("kakaoNickName", this.kakaoNickName);
//        return mv;
//    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView excuteLogin(HttpServletRequest request,
                                    @ModelAttribute("User") User user,
                                    @RequestParam("form-email") String form_email,
                                    @RequestParam("form-password") String form_password) {

        logger.info("input email : {}, input password : {} ", form_email, form_password);

        ModelAndView mv = new ModelAndView();

        user.setEmail(form_email);
        user.setPassword(form_password);

        boolean checkUser = userService.isValidUser(user);

        if (checkUser) {
            logger.info("login success");
            List<User> userList = userService.findAllUsers();
            mv.addObject("email", form_email);
            mv.addObject("name", form_email.split("@")[0]);
            mv.addObject("userList", userList);
            mv.setViewName("main");
        } else {
            logger.debug("login fail");
            mv.addObject("inValidUser", "please check login info...");
            mv.setViewName("login");
        }

        mv.addObject("pass", user.getPassword());

        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView("contents/signUp");
        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpProc(@ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView("login");
        userService.signUpUser(user);
        return mv;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView RuntimeExceptionHandler() {
        ModelAndView mv = new ModelAndView("error/errorRuntimeException");
        return mv;
    }
}