package com.skyfly33.spring.mongo;

import static org.junit.Assert.*;

import com.skyfly33.spring.mongo.dao.repository.ExternalAccountRepository;
import com.skyfly33.spring.mongo.dao.repository.ReceiverRepository;
import com.skyfly33.spring.mongo.dao.repository.ServerRepository;
import com.skyfly33.spring.mongo.dao.repository.UserRepository;
import com.skyfly33.spring.mongo.model.whoo.ExternalAccount;
import com.skyfly33.spring.mongo.model.whoo.User;
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
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    UserRepository userRepository;

    ExternalAccount externalAccount1 = new ExternalAccount();
    User user1 = new User();
    User.Server server1 = user1.new Server();
    User.Server.Receiver receiver1 = server1.new Receiver();

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

        server1.setCondition(0);
        server1.setServer_name("tomcat01");
        server1.setId(externalAccount1.getUuid() + server1.getServer_name());
        server1.setIp("211.170.163.68");
        server1.setUuid(externalAccount1.getUuid());
        server1.setReceiver(receiver1);

        user1.setEmail("skyfly33727@gmail.com");
        user1.setExternalAccount(externalAccount1);
        user1.setServer(server1);
        user1.setUuid(externalAccount1.getUuid());
        user1.setName(externalAccount1.getNickname());
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
        User.Server.Receiver findReceiver = receiverRepository.findOneById(33190001L);
        assertEquals("skyfly33", findReceiver.getExternalAccount().getNickname());
        logger.info(findReceiver.getExternalAccount().getThumbnailImg());
    }

    @Test
    public void receiverFindAllTest() {
        List<User.Server.Receiver> receiverList = receiverRepository.getAll();
        User.Server.Receiver receiver = receiverList.get(0);
        assertEquals("push-token-sample", receiver.getPushToken());
        logger.info(receiver.getDeviceToken());
    }

    @Test
    public void serverSaveTest() {
        boolean chk = serverRepository.save(server1);
        assertTrue(chk);
    }

    @Test
    public void serverFindOneByIdTest() {
        User.Server findServer = serverRepository.findOneById(33190001L);
        assertEquals("skyfly33", findServer.getReceiver().getExternalAccount().getNickname());
        logger.info(findServer.getReceiver().getExternalAccount().getThumbnailImg());
    }

    @Test
    public void serverFindAllTest() {
        List<User.Server> serverList = serverRepository.getAll();
        User.Server server = serverList.get(0);
        assertEquals("push-token-sample", server.getReceiver().getPushToken());
        logger.info(server.getReceiver().getDeviceToken());
    }

    @Test
    public void userSaveTest() {
        boolean chk = userRepository.save(user1);
        assertTrue(chk);
    }

    @Test
    public void userFindOneByIdTest() {
        User findUser = userRepository.findOneById(33190001L);
        assertEquals("skyfly33", findUser.getServer().getReceiver().getExternalAccount().getNickname());
        logger.info(findUser.getServer().getReceiver().getExternalAccount().getThumbnailImg());
    }

    @Test
    public void userFindAllTest() {
        List<User> userList = userRepository.getAll();
        User user = userList.get(0);
        assertEquals("push-token-sample", user.getServer().getReceiver().getPushToken());
        logger.info(user.getServer().getReceiver().getDeviceToken());
    }
}
