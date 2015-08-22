package com.skyfly33.spring.domain;

import org.apache.ibatis.type.Alias;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Alias("user")
public class User {

    private Long id;
    private String email;
    private String password;
    private int phone;

    public User() {
    }

    public User(Long id, String email, String password, int phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
