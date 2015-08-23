package com.skyfly33.spring.service;

import com.skyfly33.spring.dao.UserDao;
import com.skyfly33.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> allUser = new ArrayList<User>();

        allUser = userDao.findAllUsers();

        return allUser;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userDao.findUserByEmail(email);
        return user;
    }

    @Override
    public Boolean isValidUser(User user) {
        Boolean isValidUser = userDao.isValidUser(user);
        return isValidUser;
    }


}
