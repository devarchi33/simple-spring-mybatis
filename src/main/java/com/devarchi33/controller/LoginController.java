package com.devarchi33.controller;

import com.devarchi33.domain.User;
import com.devarchi33.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final String ACTIVE = "active";

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User constructor() {
        return new User();
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView mv = new ModelAndView("signUp");
        mv.addObject("message", "This is devarchi33_test registration form made with Bootstrap.");

        return mv;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpProc(@ModelAttribute("user") User user) {
        ModelAndView mv;
        User findUser = userService.findUserByEmail(user.getEmail());

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
    public ModelAndView excuteLogin(@ModelAttribute("User") User user,
                                    @RequestParam("userId") String form_email,
                                    @RequestParam("password") String form_password,
                                    HttpSession session) {

        logger.info("input email : {}, input password : {} ", form_email, form_password);

        ModelAndView mv = new ModelAndView();

        user.setEmail(form_email);
        user.setPassword(form_password);

        boolean checkUser = userService.isValidUser(user);

        if (checkUser) {
            logger.info("login success");
            mv.setViewName("main");
            mv.addObject("page", "home");
            mv.addObject("homeActive", ACTIVE);
            mv.addObject("title", "Home");

            User loginUser = userService.findUserByEmail(form_email);
            session.setAttribute("loginUser", loginUser);
        } else {
            logger.debug("login fail");
            mv.addObject("message2", "이메일 또는 패스워드를 확인해주세요.");
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

}