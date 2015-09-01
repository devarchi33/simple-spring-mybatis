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
public class OneSignalGetApps {

    Logger logger = LoggerFactory.getLogger(OneSignalGetApps.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Utils utils;

    private String adminKey = Config.getInstance().getProperties("auth_key");
    private final String URI = "https://onesignal.com/api/v1/apps";

    public void getApps() {
        utils.printTitle("Get Apps");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", " Basic NTM1MDBhOTQtNGViYS0xMWU1LWJlMWYtODcyYTI4M2U4MjM4");
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
