package com.skyfly33.spring.mongo.model.onesignal;

import com.skyfly33.spring.helper.Config;

/**
 * Created by donghoon on 15. 9. 3..
 */
public class Message {

    private final String app_id = Config.getInstance().getProperties("one_signal_rest_key");
    private boolean included_segments;
    private String send_after;
    private Content contents;

    public String getApp_id() {
        return app_id;
    }

    public boolean isIncluded_segments() {
        return included_segments;
    }

    public void setIncluded_segments(boolean included_segments) {
        this.included_segments = included_segments;
    }

    public String getSend_after() {
        return send_after;
    }

    public void setSend_after(String send_after) {
        this.send_after = send_after;
    }

    public Content getContents() {
        return contents;
    }

    public void setContents(Content contents) {
        this.contents = contents;
    }

    public class Content {
        private String en;
    }
}
