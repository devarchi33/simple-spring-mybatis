package com.skyfly33.spring.mongo;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 8. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class WhooMongoTest {

    private static final Logger logger = LoggerFactory.getLogger(WhooMongoTest.class);

    @Autowired
    MongoTemplate mongoTemplate;


}
