package com.devarchi33.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by donghoon on 15. 8. 10..
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    private final Logger logger = LoggerFactory.getLogger(CountryController.class);
    private final String ACTIVE = "active";

    @RequestMapping(value = "/germany", method = RequestMethod.GET)
    public ModelAndView germany() {

        ModelAndView mv = new ModelAndView();

        logger.info("country german page.");
        mv.setViewName("main");
        mv.addObject("page", "germany");
        mv.addObject("countryListActive", ACTIVE);
        mv.addObject("germany", ACTIVE);

        return mv;
    }

}