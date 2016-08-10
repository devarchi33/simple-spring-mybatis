package com.devarchi33.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Controller
@RequestMapping("/main")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final String ACTIVE = "active";

    private ModelAndView defalutMvSetting(ModelAndView mv) {
        mv.setViewName("main");
        mv.addObject("page", "home");
        mv.addObject("homeActive", ACTIVE);
        mv.addObject("title", "Main Page");
        return mv;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();

        defalutMvSetting(mv);

        return mv;
    }

}