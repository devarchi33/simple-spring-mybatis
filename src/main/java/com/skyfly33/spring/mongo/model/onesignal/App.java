package com.skyfly33.spring.mongo.model.onesignal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by donghoon on 15. 9. 2..
 */
@Document(collection = "onesignalapp")
public class App {

    @Id
    private Long id;
    private String name;
    private int players; //players number.
    private int messagable_players; //messagable_players number.
    private Date updated_at;
    private Date created_at;
    private String gcm_key;
    private String apns_env;
    private String apns_certificates;
    private String basic_auth_key;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getMessagable_players() {
        return messagable_players;
    }

    public void setMessagable_players(int messagable_players) {
        this.messagable_players = messagable_players;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getGcm_key() {
        return gcm_key;
    }

    public void setGcm_key(String gcm_key) {
        this.gcm_key = gcm_key;
    }

    public String getApns_env() {
        return apns_env;
    }

    public void setApns_env(String apns_env) {
        this.apns_env = apns_env;
    }

    public String getApns_certificates() {
        return apns_certificates;
    }

    public void setApns_certificates(String apns_certificates) {
        this.apns_certificates = apns_certificates;
    }

    public String getBasic_auth_key() {
        return basic_auth_key;
    }

    public void setBasic_auth_key(String basic_auth_key) {
        this.basic_auth_key = basic_auth_key;
    }
}
