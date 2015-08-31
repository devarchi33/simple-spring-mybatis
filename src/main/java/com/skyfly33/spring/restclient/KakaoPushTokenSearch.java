package com.skyfly33.spring.restclient;

import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by donghoon on 15. 8. 31..
 */
@Component
public class KakaoPushTokenSearch {

    private final Logger logger = LoggerFactory.getLogger(KakaoPushTokenSearch.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Utils utils;

    private String adminKey = Config.getInstance().getProperties("adminKey");
    private String uuid = Config.getInstance().getProperties("uuid");

    public boolean tokenSearch() {
        utils.printTitle("searchPushToken");

        try {
            URI uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("kapi.kakao.com")
                    .path("/v1/push/tokens")
                    .queryParam("uuid", uuid)
                    .build()
                    .toUri();
            logger.info("Request URI : " + uri);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", adminKey);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

            ResponseEntity<String> pushTokenResponse = restTemplate.exchange(
                    uri, HttpMethod.GET, requestEntity, String.class);
            logger.info(pushTokenResponse.toString());

            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
