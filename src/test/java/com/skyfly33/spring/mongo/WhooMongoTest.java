package com.skyfly33.spring.mongo;

import static org.junit.Assert.*;

import com.skyfly33.spring.mongo.dao.repository.ExternalAccountRepository;
import com.skyfly33.spring.mongo.model.whoo.ExternalAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class WhooMongoTest {

    private static final Logger logger = LoggerFactory.getLogger(WhooMongoTest.class);

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ExternalAccountRepository externalAccountRepository;

    ExternalAccount externalAccount = new ExternalAccount();


    @Test
    public void externalAccountSaveTest() {
        externalAccount.setNickname("skyfly33");
        externalAccount.setProfileImg("profile2.jpg");
        externalAccount.setThumbnailImg("thumbnail2.jpg");
        externalAccount.setType("kakao");
        externalAccount.setUuid(33190001L);
        boolean chk = externalAccountRepository.save(externalAccount);
        assertTrue(chk);
    }

    @Test
    public void externalAccountFindByIdTest() {
        ExternalAccount findAccount = externalAccountRepository.findById(33190000L);
        assertEquals("이동훈", findAccount.getNickname());
        logger.info(findAccount.getUuid().toString());
    }

    @Test
    public void externalAccountFindAllTest() {
        List<ExternalAccount> externalAccountList = externalAccountRepository.getAll();
        ExternalAccount externalAccount1 = externalAccountList.get(1);
        assertEquals("skyfly33", externalAccount1.getNickname());
        logger.info(externalAccount1.getNickname());
    }
}
