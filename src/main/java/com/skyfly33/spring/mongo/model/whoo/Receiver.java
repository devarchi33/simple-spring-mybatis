package com.skyfly33.spring.mongo.model.whoo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 15. 9. 8..
 */
@Document(collection = "receivers")
public class Receiver {

    @Id
    private Long uuid;
    private ExternalAccount externalAccount;
    private String pushToken;
    private String deviceToken;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public ExternalAccount getExternalAccount() {
        return externalAccount;
    }

    public void setExternalAccount(ExternalAccount externalAccount) {
        this.externalAccount = externalAccount;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
