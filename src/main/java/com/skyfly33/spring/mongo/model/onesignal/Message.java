package com.skyfly33.spring.mongo.model.onesignal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.skyfly33.spring.helper.Config;
import lombok.Data;

/**
 * Created by donghoon on 15. 9. 3..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Message {

    private String message;
    private String host;
    private String path;
    private String ip;
    private String time;
}
