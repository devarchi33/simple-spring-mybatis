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
public class OneSignalGetNotificationsById {

    Logger logger = LoggerFactory.getLogger(OneSignalGetNotificationsById.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Utils utils;
    private String one_signal_rest_key = Config.getInstance().getProperties("one_signal_rest_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private String one_signal_notification_id = Config.getInstance().getProperties("one_signal_notification_id");
    private final String URI = "https://onesignal.com/api/v1/notifications/" + one_signal_notification_id + "?app_id=" + one_signal_app_id;


    public String getNotificationsById() {
        utils.printTitle("Get Notifications By Id");

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
