package com.skyfly33.spring.mongo.model.onesignal;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 2..
 */
public class Notification {

    private String id;
    private int successful;
    private int failed;
    private int converted;
    private int remaining;
    private int queued_at;
    private List<String> included_segments;
    private Contents contents;
    private Contents headings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSuccessful() {
        return successful;
    }

    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(int converted) {
        this.converted = converted;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getQueued_at() {
        return queued_at;
    }

    public void setQueued_at(int queued_at) {
        this.queued_at = queued_at;
    }

    public List<String> getIncluded_segments() {
        return included_segments;
    }

    public void setIncluded_segments(List<String> included_segments) {
        this.included_segments = included_segments;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public Contents getHeadings() {
        return headings;
    }

    public void setHeadings(Contents headings) {
        this.headings = headings;
    }

    public class Contents {
        private String en;
        private String kr;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getKr() {
            return kr;
        }

        public void setKr(String kr) {
            this.kr = kr;
        }
    }
}
