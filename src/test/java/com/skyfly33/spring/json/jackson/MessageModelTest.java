package com.skyfly33.spring.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyfly33.spring.mongo.model.onesignal.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jeoos43 on 15. 9. 9..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/pojoApplicationContext.xml"})
public class MessageModelTest {

    Logger logger = LoggerFactory.getLogger(MessageModelTest.class);

    @Autowired
    ObjectMapper mapper;

    @Test
    public void messageModelTest() throws Exception {
        String dummy = "{\"message\":\"server3\",\"@version\":\"1\",\"@timestamp\":\"2015-09-09T01:15:14.015Z\",\"host\":\"BooSang-ui-iMac\",\"path\":\"/Users/jeoos43/logstash_conf/test.txt\",\"ip\":\"192.168.0.187\"}";
        Message readMessage = mapper.readValue(dummy, Message.class);
        logger.info(readMessage.toString());
    }
}
