package com.skyfly33.spring.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Alias("user")
@Data
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

    public User(String email, String password, int phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
