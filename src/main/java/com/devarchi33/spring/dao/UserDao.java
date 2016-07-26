package com.devarchi33.spring.dao;

import com.devarchi33.spring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Repository
public interface UserDao {

    List<User> findAllUsers();

    User findUserByEmail(String email);

    Boolean isValidUser(User user);

    void signUpUser(User user);

    void deleteUserByEmail(String email);
}
