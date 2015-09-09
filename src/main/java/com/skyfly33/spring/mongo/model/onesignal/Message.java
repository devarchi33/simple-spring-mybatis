package com.skyfly33.spring.mongo.model.onesignal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.skyfly33.spring.helper.Config;

/**
 * Created by donghoon on 15. 9. 3..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private String message;
    private String host;
    private String path;
    private String ip;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
