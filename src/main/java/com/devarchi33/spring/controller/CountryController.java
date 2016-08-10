package com.devarchi33.spring.controller;

import com.devarchi33.spring.domain.City;
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

    private ModelAndView defalutMvSetting(ModelAndView mv, City city) {
        logger.info("country " + city.getCountryName() + " " + city.getCityName() + " page.");
        mv.setViewName("main");
        mv.addObject("page", city.getCityName().toLowerCase());
        mv.addObject("countryListActive", ACTIVE);
        mv.addObject(city.getCountryName().toLowerCase(), ACTIVE);
        mv.addObject(city.getCityName().toLowerCase(), ACTIVE);
        mv.addObject("city", city);
        return mv;
    }

    @RequestMapping(value = "/germany/dresden", method = RequestMethod.GET)
    public ModelAndView dresden() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Dresden");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/hameln", method = RequestMethod.GET)
    public ModelAndView hameln() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Hameln");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/munchen", method = RequestMethod.GET)
    public ModelAndView munchen() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Munchen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/berlin", method = RequestMethod.GET)
    public ModelAndView berlin() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Berlin");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/fussen", method = RequestMethod.GET)
    public ModelAndView fussen() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Fussen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/stralsund", method = RequestMethod.GET)
    public ModelAndView stralsund() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Stralsund");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/braunschweig", method = RequestMethod.GET)
    public ModelAndView braunschweig() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Braunschweig");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/koln", method = RequestMethod.GET)
    public ModelAndView koln() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Koln");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/bremen", method = RequestMethod.GET)
    public ModelAndView bremen() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Bremen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/stuttgart", method = RequestMethod.GET)
    public ModelAndView stuttgart() {

        ModelAndView mv = new ModelAndView();
        City city = new City("Germany", "Stuttgart");

        defalutMvSetting(mv, city);

        return mv;
    }

}