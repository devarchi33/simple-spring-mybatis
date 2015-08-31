package com.skyfly33.spring.restclient;

import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by jeoos43 on 15. 8. 31..
 */
@Component
public class KakaoGetUserList {

    private final Logger logger = LoggerFactory.getLogger(KakaoGetUserList.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Utils utils;

    private String adminKey = Config.getInstance().getProperties("adminKey");
    private final String URI = "https://kapi.kakao.com/v1/user/ids";

    public void getUserList() {
        utils.printTitle("Get User List");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", adminKey);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

        ResponseEntity<String> userList = restTemplate.exchange(URI, HttpMethod.GET, requestEntity, String.class);
        HttpStatus status = userList.getStatusCode();
        HttpHeaders responseHeaders = userList.getHeaders();
        String responseBody = userList.getBody();

        logger.info(status.toString());
        logger.info(responseHeaders.toString());
        logger.info(responseBody);
    }

}
