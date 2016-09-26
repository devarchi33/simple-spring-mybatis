package com.devarchi33.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Alias("user")
@Data
@ToString
@AllArgsConstructor
public class UserInfo {

    @Id
    private String email;
    private String password;
    private String authority;

    public UserInfo() {
    }

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

}