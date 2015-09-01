package com.skyfly33.spring.restclient.onesignal;

import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by donghoon on 15. 9. 1..
 */
@Component
public class OneSignalGetPlayersById {

    Logger logger = LoggerFactory.getLogger(OneSignalGetPlayersById.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Utils utils;

    private String one_signal_player_id = Config.getInstance().getProperties("one_signal_player_id");
    private final String URI = "https://onesignal.com/api/v1/players/" + one_signal_player_id;

    public void getPlayersById() {
        utils.printTitle("Get Players By Id");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(URI, HttpMethod.GET, requestEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        String responseBody = responseEntity.getBody();

        logger.info(status.toString());
        logger.info(responseHeaders.toString());
        logger.info(responseBody);
    }
}
