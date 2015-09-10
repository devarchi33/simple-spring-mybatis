package com.skyfly33.spring.http;

import com.skyfly33.spring.restclient.onesignal.*;
import org.apache.ibatis.annotations.One;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jeoos43 on 15. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/pojoApplicationContext.xml"})
public class OneSignalRestClientTest {

    Logger logger = org.slf4j.LoggerFactory.getLogger(OneSignalRestClientTest.class);

    @Autowired
    OneSignalGetApps oneSignalGetApps;
    @Autowired
    OneSignalGetAppsById oneSignalGetAppsById;
    @Autowired
    OneSignalGetPlayers oneSignalGetPlayers;
    @Autowired
    OneSignalGetPlayersById oneSignalGetPlayersById;
    @Autowired
    OneSignalAddPlyers oneSignalAddPlyers;
    @Autowired
    OneSignalGetNotifications oneSignalGetNotifications;
    @Autowired
    OneSignalGetNotificationsById oneSignalGetNotificationsById;
    @Autowired
    OneSignalCreateNotification oneSignalCreateNotification;

    @Test
    public void getAppsTest() {
        oneSignalGetApps.getApps();
    }

    @Test
    public void getAppsByIdTest() {
        logger.info(oneSignalGetAppsById.getAppsById());
    }

    @Test
    public void getPlayersTest() {
        oneSignalGetPlayers.getPlayers();
    }

    @Test
    public void getPlayersByIdTest() {
        oneSignalGetPlayersById.getPlayersById();
    }

    @Test
    public void addPlayersTest() {
        oneSignalAddPlyers.addPlayers();
    }

    @Test
    public void getNotificationsTest() {
        logger.info(oneSignalGetNotifications.getNotifications());
    }

    @Test
    public void getNotificationsByIdTest() {
        logger.info(oneSignalGetNotificationsById.getNotificationsById());
    }

    @Test
    public void createNotificationTest() {
        logger.info(oneSignalCreateNotification.createNotification());
    }

    @Test
    public void createNotificationByApacheTest() {
        logger.info(oneSignalCreateNotification.createNotificationByApache());
    }

    @Test
    public void createNotificationByJDKTest() {
        oneSignalCreateNotification.createNotificationByJDK("testChannel","dummy");
    }
}