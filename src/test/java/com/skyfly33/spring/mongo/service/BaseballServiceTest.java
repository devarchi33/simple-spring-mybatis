package com.skyfly33.spring.mongo.service;

import static org.junit.Assert.*;

import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.dao.repository.BaseballRankingRepository;
import com.skyfly33.spring.mongo.service.impl.BaseballRankingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 9. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class BaseballServiceTest {

    @Autowired
    private BaseballRankingRepository baseballRankingRepository;
    @Autowired
    private BaseballRankingService baseballRankingService;
    private BaseballTeam kia;


    @Before
    public void setUp() {
        kia = baseballRankingRepository.findOneByTeam("kia");
    }

    @Test
    public void notNullTest() {
        assertNotNull(baseballRankingService);
    }

    @Test
    public void increaseWinTest() {
        int win = kia.getWin();
        int updateWin = baseballRankingService.increaseWin("kia");
        assertEquals(win + 1, updateWin);
    }

    @Test
    public void increaseDrawTest() {
        int draw = kia.getDraw();
        int updateDraw = baseballRankingService.increaseDraw("kia");
        assertEquals(draw + 1, updateDraw);
    }

    @Test
    public void increaseLoseTest() {
        int lose = kia.getLose();
        int updateLose = baseballRankingService.increaseLose("kia");
        assertEquals(lose + 1, updateLose);
    }
}
