package com.devarchi33.controller;

import com.devarchi33.domain.User;
import com.devarchi33.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final String ACTIVE = "active";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView userList(HttpSession session) {

        ModelAndView mv = new ModelAndView();

        boolean checkUser = session.getAttribute("loginUser") != null;

        if (checkUser) {
            User currentUser = (User) session.getAttribute("loginUser");
            List<User> userList = userService.findAllUsers();
            mv.setViewName("main");
            mv.addObject("page", "userList");
            mv.addObject("userList", userList);
            mv.addObject("userListActive", ACTIVE);

            User loginUser = userService.findUserByEmail(currentUser.getEmail());
            session.setAttribute("loginUser", loginUser);
        } else {
            logger.debug("login fail");
            mv.addObject("message2", "이메일 또는 패스워드를 확인해주세요.");
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUserPage(@RequestParam String email) {
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("name", email.split("@")[0]);
        mv.addObject("page", "editUser");
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@RequestParam String editEmail,
                                 @RequestParam String editPassword) {

        ModelAndView mv = new ModelAndView("main");
        mv.addObject("page", "userList");

        User editUser = new User(editEmail, editPassword);
        userService.updateUser(editUser);
        List<User> userList = userService.findAllUsers();
        mv.addObject("userList", userList);

        return mv;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam String email) {
        logger.debug("delete email: {}", email);

        ModelAndView mv = new ModelAndView("main");
        userService.deleteUserByEmail(email);

        List<User> userList = userService.findAllUsers();
        mv.addObject("userList", userList);

        return mv;
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ModelAndView RuntimeExceptionHandler() {
//        ModelAndView mv = new ModelAndView("error/errorRuntimeException");
//        return mv;
//    }

}