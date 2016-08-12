package com.devarchi33.controller;

import com.devarchi33.domain.City;
import com.devarchi33.domain.Country;
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
        mv.addObject("page", "city");
        mv.addObject("countryListActive", ACTIVE);
        mv.addObject(city.getCountryName().toLowerCase(), ACTIVE);
        mv.addObject(city.getCityName().toLowerCase(), ACTIVE);
        mv.addObject("city", city);
        return mv;
    }

    //    GERMANY
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
        City city = new City(Country.GERMANY.getCountryName(), "Hameln");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/munchen", method = RequestMethod.GET)
    public ModelAndView munchen() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Munchen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/berlin", method = RequestMethod.GET)
    public ModelAndView berlin() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Berlin");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/fussen", method = RequestMethod.GET)
    public ModelAndView fussen() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Fussen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/stralsund", method = RequestMethod.GET)
    public ModelAndView stralsund() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Stralsund");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/braunschweig", method = RequestMethod.GET)
    public ModelAndView braunschweig() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Braunschweig");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/koln", method = RequestMethod.GET)
    public ModelAndView koln() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Koln");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/bremen", method = RequestMethod.GET)
    public ModelAndView bremen() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Bremen");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/germany/stuttgart", method = RequestMethod.GET)
    public ModelAndView stuttgart() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.GERMANY.getCountryName(), "Stuttgart");

        defalutMvSetting(mv, city);

        return mv;
    }

    //    USA
    @RequestMapping(value = "/usa/boston", method = RequestMethod.GET)
    public ModelAndView boston() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Boston");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/la", method = RequestMethod.GET)
    public ModelAndView la() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "La");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/washington", method = RequestMethod.GET)
    public ModelAndView washington() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Washington");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/baltimore", method = RequestMethod.GET)
    public ModelAndView baltimore() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Baltimore");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/texas", method = RequestMethod.GET)
    public ModelAndView texas() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Texas");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/philadelphia", method = RequestMethod.GET)
    public ModelAndView philadelphia() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Philadelphia");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/sandiego", method = RequestMethod.GET)
    public ModelAndView sandiego() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Sandiego");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/arizona", method = RequestMethod.GET)
    public ModelAndView arizona() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Arizona");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/chicago", method = RequestMethod.GET)
    public ModelAndView chicago() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Chicago");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/usa/seattle", method = RequestMethod.GET)
    public ModelAndView seattle() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.USA.getCountryName(), "Seattle");

        defalutMvSetting(mv, city);

        return mv;
    }

    //    UK
    @RequestMapping(value = "/uk/cardiff", method = RequestMethod.GET)
    public ModelAndView cardiff() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Cardiff");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/leeds", method = RequestMethod.GET)
    public ModelAndView leeds() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Leeds");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/birmingham", method = RequestMethod.GET)
    public ModelAndView birmingham() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Birmingham");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/liverpool", method = RequestMethod.GET)
    public ModelAndView liverpool() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Liverpool");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/manchester", method = RequestMethod.GET)
    public ModelAndView manchester() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Manchester");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/london", method = RequestMethod.GET)
    public ModelAndView london() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "London");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/southamton", method = RequestMethod.GET)
    public ModelAndView southamton() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Southamton");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/norwich", method = RequestMethod.GET)
    public ModelAndView norwich() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Norwich");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/leicester", method = RequestMethod.GET)
    public ModelAndView leicester() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Leicester");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/uk/newcastle", method = RequestMethod.GET)
    public ModelAndView newcastle() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.UK.getCountryName(), "Newcastle");

        defalutMvSetting(mv, city);

        return mv;
    }

    //    korea
    @RequestMapping(value = "/korea/incheon", method = RequestMethod.GET)
    public ModelAndView incheon() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Incheon");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/seoul", method = RequestMethod.GET)
    public ModelAndView seoul() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Seoul");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/bucheon", method = RequestMethod.GET)
    public ModelAndView bucheon() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Bucheon");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/ilsan", method = RequestMethod.GET)
    public ModelAndView ilsan() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Ilsan");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/suwon", method = RequestMethod.GET)
    public ModelAndView suwon() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Suwon");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/daegu", method = RequestMethod.GET)
    public ModelAndView daegu() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Daegu");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/pusan", method = RequestMethod.GET)
    public ModelAndView pusan() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Pusan");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/gwangju", method = RequestMethod.GET)
    public ModelAndView gwangju() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Gwangju");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/daejeon", method = RequestMethod.GET)
    public ModelAndView daejeon() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Daejeon");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/korea/jeju", method = RequestMethod.GET)
    public ModelAndView jeju() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.KOREA.getCountryName(), "Jeju");

        defalutMvSetting(mv, city);

        return mv;
    }

    //    spain
    @RequestMapping(value = "/spain/barcelona", method = RequestMethod.GET)
    public ModelAndView barcelona() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Barcelona");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/bilbao", method = RequestMethod.GET)
    public ModelAndView bilbao() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Bilbao");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/cordoba", method = RequestMethod.GET)
    public ModelAndView cordoba() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Cordoba");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/granada", method = RequestMethod.GET)
    public ModelAndView granada() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Granada");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/madrid", method = RequestMethod.GET)
    public ModelAndView madrid() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Madrid");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/malaga", method = RequestMethod.GET)
    public ModelAndView malaga() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Malaga");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/salamanca", method = RequestMethod.GET)
    public ModelAndView salamanca() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Salamanca");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/sevilla", method = RequestMethod.GET)
    public ModelAndView sevilla() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Sevilla");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/valencia", method = RequestMethod.GET)
    public ModelAndView valencia() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Valencia");

        defalutMvSetting(mv, city);

        return mv;
    }

    @RequestMapping(value = "/spain/zaragoza", method = RequestMethod.GET)
    public ModelAndView zaragoza() {

        ModelAndView mv = new ModelAndView();
        City city = new City(Country.SPAIN.getCountryName(), "Zaragoza");

        defalutMvSetting(mv, city);

        return mv;
    }

}