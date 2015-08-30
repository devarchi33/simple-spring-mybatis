package com.skyfly33.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donghoon on 15. 8. 23..
 */
@Controller
@RequestMapping(value = "/static")
public class StaticController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHtmlWelcome() {
        return "redirect:/resources/app/index.html";
    }
}
