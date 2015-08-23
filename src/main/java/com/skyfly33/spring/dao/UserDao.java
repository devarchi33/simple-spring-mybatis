package com.skyfly33.spring.dao;

import com.skyfly33.spring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 22..
 */
@Repository
public interface UserDao {

    List<User> findAllUsers();
}
