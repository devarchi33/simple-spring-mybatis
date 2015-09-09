package com.skyfly33.spring.controller;

import com.skyfly33.spring.domain.Code;
import com.skyfly33.spring.pubsub.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

/**
 * Created by donghoon on 15. 8. 25..
 */
@Controller
@RequestMapping("/whoo")
public class WHOOController {

    private final Logger logger = LoggerFactory.getLogger(WHOOController.class);

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

    @RequestMapping(value = "/upsert", method = RequestMethod.POST)
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

    @RequestMapping(value = "/messageOnOff", method = RequestMethod.POST)
    public
    @ResponseBody
    Object messageOnOff(@RequestParam String uid,
                        @RequestParam String pid) {
        logger.info("messageOnOff!");
        logger.info("input uuid: " + uid);
        logger.info("input players_id: " + pid);
        Code vo = new Code();

        vo.setCode("Return: " + uid + ", " + pid);
        createSubscriber(uid);

        return vo;
    }

    private void createSubscriber(final String channelName) {
        final Jedis subscriberJedis = new Jedis();
        final Subscriber subscriber = new Subscriber();

        new Thread(new Runnable() {
            public void run() {
                try {
                    logger.info("Subscribing to \"" + channelName + "\". This thread will be blocked.");
                    subscriberJedis.subscribe(subscriber, channelName);
                    logger.info("Subscription ended.");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("Subscribing failed." + e);
                }
            }
        }).start();
    }
}
