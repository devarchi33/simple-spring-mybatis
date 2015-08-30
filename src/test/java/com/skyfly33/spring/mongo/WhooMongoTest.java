package com.skyfly33.spring.mongo;

import com.skyfly33.spring.mongo.model.ExternalAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by donghoon on 15. 8. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mongoApplicationContext.xml"})
public class WhooMongoTest {

    private static final Logger logger = LoggerFactory.getLogger(WhooMongoTest.class);

    @Autowired
    MongoTemplate mongoTemplate;

    ExternalAccount ea = new ExternalAccount();

    @Test
    public void insertTest() {
        ea.setType("kakao");
        mongoTemplate.insert(ea);
    }

    @Test
    public void findTest() {
        Query query = query(where("type").is("kakao"));
        ExternalAccount eaf = mongoTemplate.findOne(query, ExternalAccount.class);
        logger.info(eaf.getType());
    }

    @Test
    public void updateTest() {
        Query query = query(where("type").is("kakao"));
        mongoTemplate.updateMulti(query, new Update().set("type", "facebook"), ExternalAccount.class);
    }


}
