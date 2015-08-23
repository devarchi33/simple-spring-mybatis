package com.skyfly33.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Controller
@RequestMapping("/")
public class CubeoneController {

    private ModelAndView mv;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Login Form");
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mainView() {
        return "main";
    }
}