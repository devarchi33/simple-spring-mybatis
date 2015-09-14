package com.skyfly33.spring.mongo.service;

import static org.junit.Assert.*;

import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.dao.repository.BaseballRankingRepository;
import com.skyfly33.spring.mongo.service.impl.BaseballRankingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class BaseballServiceTest {

    private final Logger logger = LoggerFactory.getLogger(BaseballServiceTest.class);
    @Autowired
    private BaseballRankingRepository baseballRankingRepository;
    @Autowired
    private BaseballRankingService baseballRankingService;
    private BaseballTeam kia;
    private BaseballTeam samsung;
    private BaseballTeam nc;
    private BaseballTeam nexen;
    private BaseballTeam doosan;
    private BaseballTeam lotte;
    private BaseballTeam hanhwa;
    private BaseballTeam sk;
    private BaseballTeam lg;
    private BaseballTeam kt;


    @Before
    public void setUp() {
        kia = baseballRankingRepository.findOneByTeam("kia");
        samsung = baseballRankingRepository.findOneByTeam("samsung");
        nc = baseballRankingRepository.findOneByTeam("nc");
        nexen = baseballRankingRepository.findOneByTeam("nexen");
        doosan = baseballRankingRepository.findOneByTeam("doosan");
        lotte = baseballRankingRepository.findOneByTeam("lotte");
        hanhwa = baseballRankingRepository.findOneByTeam("hanhwa");
        sk = baseballRankingRepository.findOneByTeam("sk");
        lg = baseballRankingRepository.findOneByTeam("lg");
        kt = baseballRankingRepository.findOneByTeam("kt");
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
        int lose = sk.getLose();
        int updateLose = baseballRankingService.increaseLose("sk");
        assertEquals(lose + 1, updateLose);
    }

    @Test
    public void sortTeamByFieldTest() {
        List<BaseballTeam> teamList = baseballRankingService.sortTeamByField("winning_rate");
        assertEquals(10, teamList.size());

        logger.info("1st: " + teamList.get(0).getTeam());
        for (BaseballTeam team : teamList) {
            logger.info("Team: " + team.getTeam());
        }
    }

    @Test
    public void updateGameBehind() {
        baseballRankingService.updateGameBehind("nexen");
    }
}
