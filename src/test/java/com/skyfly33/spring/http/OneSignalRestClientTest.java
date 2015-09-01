package com.skyfly33.spring.http;

import com.skyfly33.spring.restclient.kakao.*;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetApps;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetAppsById;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetPlayers;
import com.skyfly33.spring.restclient.onesignal.OneSignalGetPlayersById;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jeoos43 on 15. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/pojoApplicationContext.xml"})
public class OneSignalRestClientTest {

    @Autowired
    OneSignalGetApps oneSignalGetApps;
    @Autowired
    OneSignalGetAppsById oneSignalGetAppsById;
    @Autowired
    OneSignalGetPlayers oneSignalGetPlayers;
    @Autowired
    OneSignalGetPlayersById oneSignalGetPlayersById;

    @Test
    public void getAppsTest() {
        oneSignalGetApps.getApps();
    }

    @Test
    public void getAppsByIdTest() {
        oneSignalGetAppsById.getAppsById();
    }

    @Test
    public void getPlayersTest() {
        oneSignalGetPlayers.getPlayers();
    }

    @Test
    public void getPlayersById() {
        oneSignalGetPlayersById.getPlayersById();
    }

    
}