package com.skyfly33.spring.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyfly33.spring.mongo.model.onesignal.App;
import com.skyfly33.spring.mongo.model.onesignal.Player;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetAppsById;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetPlayersById;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 9. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/pojoApplicationContext.xml"})
public class OneSignalModelTest {

    Logger logger = LoggerFactory.getLogger(OneSignalModelTest.class);

    @Autowired
    OneSignalGetAppsById oneSignalGetAppsById;
    @Autowired
    OneSignalGetPlayersById oneSignalGetPlayersById;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAppsToJsonTest() {
        String app = oneSignalGetAppsById.getAppsById();
        try {
            App app1 = mapper.readValue(app, App.class);
            logger.info(app1.getApns_certificates());
            logger.info(app1.getGcm_key());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPlayersToJsonTest() {
        String player = oneSignalGetPlayersById.getPlayersById();
        try {
            Player player1 = mapper.readValue(player, Player.class);
            logger.info(player1.getDevice_model());
            logger.info(player1.getTags().getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
