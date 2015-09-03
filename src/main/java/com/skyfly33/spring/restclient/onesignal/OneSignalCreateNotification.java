package com.skyfly33.spring.restclient.onesignal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import org.apache.http.util.EncodingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by donghoon on 15. 9. 3..
 */
@Component
public class OneSignalCreateNotification {

    Logger logger = LoggerFactory.getLogger(OneSignalCreateNotification.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    Utils utils;

    private String one_signal_rest_api_key = Config.getInstance().getProperties("one_signal_rest_api_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/notifications";

    public String createNotification() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", one_signal_rest_api_key);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        byte[] messageParam = messageBuilder(one_signal_app_id, "Message by Spring Resttemplate", "ALL");
        logger.info("Message Param: " + messageParam);

//        byte[] rawMessageParam = EncodingUtils.getBytes(messageParam, "utf-8");

        HttpEntity<byte[]> requestEntity = new HttpEntity<>(messageParam, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        String responseBody = responseEntity.getBody();

        logger.info(status.toString());
        logger.info(responseHeaders.toString());
        logger.info(responseBody);

        return status.toString();
    }

    private byte[] messageBuilder(String app_id, String enMessage, String segment) {
        try {
            Map<String, Object> messageData = new HashMap<String, Object>();
            Map<String, String> contentsStruct = new HashMap<String, String>();
            contentsStruct.put("en", enMessage);
            messageData.put("app_id", app_id);
            messageData.put("contents", contentsStruct);
            List<String> segments = new ArrayList<String>();
            messageData.put("included_segments", segments.add(segment));
            messageData.put("send_after", "Fri May 02 2014 00:00:00 GMT-0700 (PDT)");
//            String jsonStr = mapper.writeValueAsString(messageData);
            byte[] jsonByte = mapper.writeValueAsBytes(messageData);
            return jsonByte;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class Message {
        private String app_id;
//        private
    }
}
