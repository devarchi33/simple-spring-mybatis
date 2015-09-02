package com.skyfly33.spring.helper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/pojoApplicationContext.xml"})
public class ConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(ConfigTest.class);

    @Autowired
    Config whooConfig;

    @Test
    public void configReadTest() {
        String dburl = whooConfig.getProperties("db.url");
        logger.info("Result: " + dburl);
        assertEquals("jdbc:mysql://192.168.0.225", dburl);
    }
}