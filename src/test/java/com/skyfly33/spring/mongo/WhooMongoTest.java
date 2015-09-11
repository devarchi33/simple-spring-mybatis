package com.skyfly33.spring.mongo;

import static org.junit.Assert.*;

import com.skyfly33.spring.mongo.dao.repository.ExternalAccountRepository;
import com.skyfly33.spring.mongo.dao.repository.ReceiverRepository;
import com.skyfly33.spring.mongo.model.whoo.ExternalAccount;
import com.skyfly33.spring.mongo.model.whoo.Receiver;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donghoon on 15. 8. 30..
 */
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class WhooMongoTest {

    private static final Logger logger = LoggerFactory.getLogger(WhooMongoTest.class);

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ExternalAccountRepository externalAccountRepository;
    @Autowired
    ReceiverRepository receiverRepository;

    ExternalAccount externalAccount1 = new ExternalAccount();
    Receiver receiver1 = new Receiver();

    @Before
    public void setUp() {
        externalAccount1.setNickname("skyfly33");
        externalAccount1.setThumbnailImg("thumbnail01.jpg");
        externalAccount1.setType("kakao");
        externalAccount1.setUuid(33190001L);

        receiver1.setUuid(externalAccount1.getUuid());
        receiver1.setDeviceToken("device-token-sample");
        receiver1.setPushToken("push-token-sample");
        receiver1.setExternalAccount(externalAccount1);
    }

    @Test
    public void externalAccountSaveTest() {
        boolean chk = externalAccountRepository.save(externalAccount1);
        assertTrue(chk);
    }

    @Test
    public void externalAccountFindOneByIdTest() {
        ExternalAccount findAccount = externalAccountRepository.findOneById(33190001L);
        assertEquals("skyfly33", findAccount.getNickname());
        logger.info(findAccount.getUuid().toString());
    }

    @Test
    public void externalAccountFindAllTest() {
        List<ExternalAccount> externalAccountList = externalAccountRepository.getAll();
        ExternalAccount externalAccount1 = externalAccountList.get(0);
        assertEquals("skyfly33", externalAccount1.getNickname());
        logger.info(externalAccount1.getNickname());
    }

    @Test
    public void receiverSaveTest() {
        boolean chk = receiverRepository.save(receiver1);
        assertTrue(chk);
    }

    @Test
    public void receiverFindOneByIdTest() {
        Receiver findReceiver = receiverRepository.findOneById(33190001L);
        assertEquals("skyfly33", findReceiver.getExternalAccount().getNickname());
        logger.info(findReceiver.getExternalAccount().getThumbnailImg());
    }

    @Test
    public void receiverFindAllTest() {
        List<Receiver> receiverList = receiverRepository.getAll();
        Receiver receiver = receiverList.get(0);
        assertEquals("push-token-sample", receiver.getPushToken());
        logger.info(receiver.getDeviceToken());
    }
}
