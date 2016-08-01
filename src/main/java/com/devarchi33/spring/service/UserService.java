package com.devarchi33.spring.service;

import com.devarchi33.spring.dao.UserDao;
import com.devarchi33.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Service
public interface UserService {

    @Autowired
    UserDao userDao = null;

    void signUpUser(User user);

    String dummyQuery();

    List<User> findAllUsers();

    User findUserByEmail(String email);

    Boolean isValidUser(User user);

    void updateUser(User user);

    void deleteUserByEmail(String email);
}
