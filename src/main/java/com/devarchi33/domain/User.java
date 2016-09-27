package com.devarchi33.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class User {

    @Id
    private String email;
    private String password;
    private String authority;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}