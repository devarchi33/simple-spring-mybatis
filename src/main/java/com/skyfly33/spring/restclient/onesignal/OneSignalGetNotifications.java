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
 * Created by donghoon on 15. 9. 2..
 */
@Component
public class OneSignalGetNotifications {

    Logger logger = LoggerFactory.getLogger(OneSignalGetNotifications.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Utils utils;
    private String one_signal_rest_key = Config.getInstance().getProperties("one_signal_rest_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/notifications?app_id=" + one_signal_app_id;

    public String getNotifications() {
        utils.printTitle("Get Notifications");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", one_signal_rest_key);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(URI, HttpMethod.GET, requestEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        String responseBody = responseEntity.getBody();

        logger.info(status.toString());
        logger.info(responseHeaders.toString());
        logger.info(responseBody);

        return responseBody;
    }
}
