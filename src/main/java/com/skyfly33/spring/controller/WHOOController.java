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
    private Jedis subscriberJedis;
    private Subscriber subscriber = new Subscriber();

    @RequestMapping("/setKakaoAuthCode")
    public String setAuthCode(@RequestBody String kakaoAuthCode) {
        logger.info("kakaoAuthCode: " + kakaoAuthCode);
        return kakaoAuthCode;
    }

    @RequestMapping(value = "/get/userInfo")
    public
    @ResponseBody
    String saveAuthCode(@RequestParam String code) {
        logger.info("Auth Code: " + code);
        return code;
    }

    @RequestMapping(value = "/getKey", method = RequestMethod.POST)
    public
    @ResponseBody
    Object getKakaoRestKey() {
        Code vo = new Code();
        logger.info("Send Kakao RestKey to App");

        return vo;
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

    @RequestMapping(value = "/messageOn", method = RequestMethod.POST)
    public
    @ResponseBody
    Object messageOn(@RequestParam String uid,
                     @RequestParam String pid) {
        logger.info("messageOn!");
        logger.info("input uuid: " + uid);
        logger.info("input players_id: " + pid);
        Code vo = new Code();

        vo.setCode("MessageOn Return: " + uid + ", " + pid);
        createSubscriber(uid, pid);

        return vo;
    }

    @RequestMapping(value = "/messageOff", method = RequestMethod.POST)
    public
    @ResponseBody
    Object messageOff(@RequestParam String uid,
                      @RequestParam String pid) {
        logger.info("messageOff!");
        logger.info("input uuid: " + uid);
        logger.info("input players_id: " + pid);
        Code vo = new Code();

        vo.setCode("MessageOff Return: " + uid + ", " + pid);
        removeSubscriber(pid);

        return vo;
    }

    private void createSubscriber(String userId, String channelName) {
        logger.info("Subscribing to \"" + userId + "\". This thread will be blocked.");
        subscriberJedis = new Jedis();
        subscriberJedis.subscribe(subscriber, channelName);
        logger.info("Subscription ended.");
    }

    private void removeSubscriber(String channel) {
        subscriber.unsubscribe(channel);
    }
}
