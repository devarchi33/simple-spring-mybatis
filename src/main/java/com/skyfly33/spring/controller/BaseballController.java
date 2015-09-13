package com.skyfly33.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by donghoon on 15. 8. 25..
 */
@Controller
@RequestMapping("/sports/baseball")
public class BaseballController {

    Logger logger = LoggerFactory.getLogger(BaseballController.class);

    @RequestMapping("/setKakaoAuthCode")
    public String setAuthCode(@RequestBody String kakaoAuthCode) {
        logger.info("kakaoAuthCode" + kakaoAuthCode);
        return kakaoAuthCode;
    }
}
