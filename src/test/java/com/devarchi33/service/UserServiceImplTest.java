package com.devarchi33.service;

import com.devarchi33.dao.UserDao;
import com.devarchi33.domain.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 23..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mybatis-scan.xml"})
public class UserServiceImplTest extends TestCase {

    @Autowired
    UserDao userDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindAllUsers() throws Exception {
        List<User> userList = userDao.findAllUsers();
        User user1 = userList.get(0);
        assertEquals("skyfly33@iruen.com", user1.getEmail());
    }
}