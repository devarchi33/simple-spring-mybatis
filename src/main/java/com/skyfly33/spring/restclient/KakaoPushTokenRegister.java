package com.skyfly33.spring.restclient;

import com.skyfly33.spring.helper.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by donghoon on 15. 8. 31..
 */
@Component
public class KakaoPushTokenRegister {

    private final Logger logger = LoggerFactory.getLogger(KakaoPushTokenRegister.class);

    @Autowired
    RestTemplate restTemplate;

    private String adminKey = Config.getInstance().getProperties("adminKey");
    private String uuid = Config.getInstance().getProperties("uuid");
    private String device_id = Config.getInstance().getProperties("device_id");
    private String push_type = Config.getInstance().getProperties("push_type");
    private String push_token = Config.getInstance().getProperties("push_token");
    private final String URI = "https://kapi.kakao.com/v1/push/register";

    public boolean tokenRegister() {
        printTitle("Token Register");

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", adminKey);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
            paramMap.add("uuid", uuid);
            paramMap.add("device_id", device_id);
            paramMap.add("push_type", push_type);
            paramMap.add("push_token", push_token);

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramMap, headers);

            ResponseEntity<String> registerResponse = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, String.class);
            logger.info(registerResponse.toString());

            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void printTitle(String title) {
        System.out.println("\n\n");
        System.out.println("[" + title + "]");
    }

}
