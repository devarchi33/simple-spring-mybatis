package com.skyfly33.spring.controller;

import com.skyfly33.spring.domain.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by donghoon on 15. 8. 25..
 */
@Controller
@RequestMapping("/whoo")
public class WHOOController {

    Logger logger = LoggerFactory.getLogger(WHOOController.class);

    @RequestMapping("/setKakaoAuthCode")
    public String setAuthCode(@RequestBody String kakaoAuthCode) {
        logger.info("kakaoAuthCode" + kakaoAuthCode);
        return kakaoAuthCode;
    }

    @RequestMapping(value = "/get/userInfo")
    public
    @ResponseBody
    String saveAuthCode(@RequestParam String code) {
        logger.info("Auth Code : " + code);
        return code;
    }

    @RequestMapping(value = "/upsert")
    public
    @ResponseBody
    Object sendUuidTest(@RequestParam String uid,
                        @RequestParam String pid) {
        logger.info("sendUuid test!");
        logger.info("input uuid: " + uid);
        logger.info("input players_id: " + pid);
        Code vo = new Code();

        vo.setCode("Return: " + uid + ", " + pid);

        return vo;
    }
}
