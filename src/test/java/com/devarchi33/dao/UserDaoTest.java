package com.devarchi33.dao;

import com.devarchi33.domain.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 8. 23..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mybatis-scan.xml"})
public class UserDaoTest extends TestCase {

    @Autowired
    UserDao userDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSetUserDao() throws Exception {
        assertNotNull(userDao);
    }

    @Test
    public void testFindUserByEmail() throws Exception {
        String email = "skyfly33@iruen.com";
        User user = userDao.findUserByEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testIsValidUser() throws Exception {
        User loginParam = new User("skyfly33@iruen.com", "iruen", "admin");

        Boolean isValidUser = userDao.isValidUser(loginParam);
        assertTrue(isValidUser);
    }

    @Test
    public void testSignUpUser() throws Exception {
        User signUpUser = new User("devarchi33@gmail.com", "devarchi33");

        userDao.signUpUser(signUpUser);

        User getSignUpUser = userDao.findUserByEmail(signUpUser.getEmail());
        assertEquals(signUpUser.getEmail(), getSignUpUser.getEmail());
    }
}