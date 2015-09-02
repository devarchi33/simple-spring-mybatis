package com.skyfly33.spring.mongo.model.onesignal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by donghoon on 15. 9. 2..
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    private String id;
    private String identifier;
    private int session_count;
    private String language;
    private int timezone;
    private String game_version;
    private String device_os;
    private int device_type;
    private String device_model;
    private String ad_id;
    private Tags tags;
    private int last_active;
    private String amount_spent;
    private int created_at;
    private boolean invalid_identifier;
    private int badge_count;
    private int playtime;
    private String facebook_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getSession_count() {
        return session_count;
    }

    public void setSession_count(int session_count) {
        this.session_count = session_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getGame_version() {
        return game_version;
    }

    public void setGame_version(String game_version) {
        this.game_version = game_version;
    }

    public String getDevice_os() {
        return device_os;
    }

    public void setDevice_os(String device_os) {
        this.device_os = device_os;
    }

    public int getDevice_type() {
        return device_type;
    }

    public void setDevice_type(int device_type) {
        this.device_type = device_type;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public int getLast_active() {
        return last_active;
    }

    public void setLast_active(int last_active) {
        this.last_active = last_active;
    }

    public String getAmount_spent() {
        return amount_spent;
    }

    public void setAmount_spent(String amount_spent) {
        this.amount_spent = amount_spent;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public boolean isInvalid_identifier() {
        return invalid_identifier;
    }

    public void setInvalid_identifier(boolean invalid_identifier) {
        this.invalid_identifier = invalid_identifier;
    }

    public int getBadge_count() {
        return badge_count;
    }

    public void setBadge_count(int badge_count) {
        this.badge_count = badge_count;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public class Tags {

        private String type;
        private String uuid;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
