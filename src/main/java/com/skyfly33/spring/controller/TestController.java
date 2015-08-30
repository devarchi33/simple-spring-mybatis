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
 * Created by donghoon on 15. 8. 30..
 */
@Controller
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/jsontest")
    public @ResponseBody Object jsonTest(){
        logger.info("jsontest!");
        Code vo = new Code();

        vo.setCode("skyfly33");

        return vo;
    }
}
