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
public class OneSignalGetPlayers {

    Logger logger = LoggerFactory.getLogger(OneSignalGetPlayers.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Utils utils;

    private String one_signal_rest_api_key = Config.getInstance().getProperties("one_signal_rest_api_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
//    private final String URI = "https://onesignal.com/api/v1/players?app_id=" + one_signal_app_id;
    private final String URI = "https://onesignal.com/api/v1/players?app_id=" + one_signal_app_id + "&limit=2&offset=1"; //params: limit(optional), offset(option)

    public void getPlayers() {
        utils.printTitle("Get Players");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", one_signal_rest_api_key);
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
