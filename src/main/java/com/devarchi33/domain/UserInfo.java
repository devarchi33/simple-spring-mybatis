package com.devarchi33.domain;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Alias("user")
@Data
@ToString
public class UserInfo {

    private Long id;
    private String email;
    private String password;
    private String authority;

    public UserInfo() {
    }

    public UserInfo(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

}