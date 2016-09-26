package com.devarchi33.service;

import com.devarchi33.dao.UserDao;
import com.devarchi33.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donghoon on 16. 9. 26..
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    public String dummyQuery() {
        return userDao.dummyQuery();
    }

    public void signUpUser(UserInfo user) {
        userDao.signUpUser(user);
    }

    public List<UserInfo> findAllUsers() {
        List<UserInfo> allUser;

        allUser = userDao.findAllUsers();

        return allUser;
    }

    public UserInfo findUserByEmail(String email) {
        UserInfo user = userDao.findUserByEmail(email);
        return user;
    }

    /**
     * Implements UserDetailsService
     *
     * @param loginEmail
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String loginEmail) throws UsernameNotFoundException {
        UserInfo userInfo = findUserByEmail(loginEmail);

        if (userInfo == null) {
            throw new UsernameNotFoundException(loginEmail);
        }

        log.debug("UserInfo: {}", userInfo.toString());

        List<String> permList = loadPermission(userInfo);
        List<GrantedAuthority> auth = new ArrayList<>();
        for (String perm : permList) {
            auth.add(new SimpleGrantedAuthority(perm));
        }
        return new org.springframework.security.core.userdetails.User(loginEmail, userInfo.getPassword(), auth);
    }

    public void updateUser(UserInfo user) {
        userDao.updateUser(user);
    }

    public void deleteUserByEmail(String email) {
        userDao.deleteUserByEmail(email);
    }

    private List<String> loadPermission(UserInfo userInfo) {
        return Arrays.asList(userInfo.getAuthority().toString());
    }

}
