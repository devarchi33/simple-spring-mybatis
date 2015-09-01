package com.skyfly33.spring.restclient.onesignal;

import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
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
 * Created by donghoon on 15. 9. 1..
 */
@Component
public class OneSignalAddPlyers {

    Logger logger = LoggerFactory.getLogger(OneSignalAddPlyers.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Utils utils;

    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/players";

    public boolean addPlayers() {
        utils.printTitle("Add Players");

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
            paramMap.add("app_id", one_signal_app_id);  //required
            paramMap.add("device_type", "2");  //required 0 = iOS, 1 = Android, 2 = Amazon, 3 = Windows Phone

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramMap, headers);

            ResponseEntity<String> responseEntity = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, String.class);

            HttpStatus status = responseEntity.getStatusCode();
            HttpHeaders responseHeaders = responseEntity.getHeaders();
            String responseBody = responseEntity.getBody();

            logger.info(status.toString());
            logger.info(responseHeaders.toString());
            logger.info(responseBody);
            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}