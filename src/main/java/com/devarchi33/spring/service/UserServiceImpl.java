package com.devarchi33.spring.service;

import com.devarchi33.spring.dao.UserDao;
import com.devarchi33.spring.domain.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;

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
        List<User> allUser;

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
        User findUser = userDao.findUserByEmail(user.getEmail());

        if (findUser == null) {
            return false;
        }

        Boolean isValidUser;

        if (user.getEmail().equals(findUser.getEmail()) && user.getPassword().equals(findUser.getPassword())) {
            isValidUser = true;
            return isValidUser;
        } else {
            isValidUser = false;
            return isValidUser;
        }
    }

    @Override
    public void signUpUser(User user) {
        userDao.signUpUser(user);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userDao.deleteUserByEmail(email);
    }

}
