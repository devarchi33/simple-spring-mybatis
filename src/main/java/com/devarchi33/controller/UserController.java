package com.devarchi33.controller;

import com.devarchi33.domain.UserInfo;
import com.devarchi33.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 * Modified by donghoon on 16. 9. 26..
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final String ACTIVE = "active";

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView userList() {

        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAllUsers();
        mv.setViewName("main");
        mv.addObject("page", "userList");
        mv.addObject("userList", userList);
        mv.addObject("userListActive", ACTIVE);

        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUserPage(@RequestParam String email) {
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("name", email.split("@")[0]);
        mv.addObject("editEmail", email);
        mv.addObject("page", "editUser");
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@RequestParam String editEmail,
                                 @RequestParam String editPassword,
                                 @RequestParam String editAuthority) {

        ModelAndView mv = new ModelAndView("main");
        mv.addObject("page", "userList");

        UserInfo editUser = userService.findUserByEmail(editEmail);
        editUser.setPassword(encoder.encode(editPassword));
        editUser.setAuthority(editAuthority);
        userService.updateUser(editUser);

        List<UserInfo> userList = userService.findAllUsers();
        mv.addObject("userList", userList);

        return mv;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam String email) {
        logger.debug("delete email: {}", email);

        ModelAndView mv = new ModelAndView("main");
        userService.deleteUserByEmail(email);

        List<UserInfo> userList = userService.findAllUsers();
        mv.addObject("userList", userList);

        return mv;
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ModelAndView RuntimeExceptionHandler() {
//        ModelAndView mv = new ModelAndView("error/errorRuntimeException");
//        return mv;
//    }

}