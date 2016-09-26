package com.devarchi33.dao;

import com.devarchi33.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Repository
public interface UserDao {

    void signUpUser(UserInfo user);

    String dummyQuery();

    List<UserInfo> findAllUsers();

    UserInfo findUserByEmail(String email);

    Boolean isValidUser(UserInfo user);

    void updateUser(UserInfo user);

    void deleteUserByEmail(String email);
}
