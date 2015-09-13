package com.skyfly33.spring.mongo;

import static org.junit.Assert.*;

import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.repository.BaseballRankingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class BaseballTest {

    Logger logger = LoggerFactory.getLogger(BaseballTest.class);

    @Autowired
    BaseballRankingRepository baseballRankingRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void findByTeamTest() {
        assertNotNull(baseballRankingRepository);
        BaseballTeam kia = baseballRankingRepository.findOneByTeam("kia");
        assertEquals("kia", kia.getTeam());
        logger.info("Team: " + kia.getTeam());
    }

    @Test
    public void getAllTest() {
        List<BaseballTeam> teamList = baseballRankingRepository.getAll();
        assertEquals(10, teamList.size());

        for (BaseballTeam team : teamList) {
            logger.info("Team: " + team.getTeam());
        }
    }

    @Test
    public void increaseWinTest() {
        BaseballTeam kia = baseballRankingRepository.findOneByTeam("kia");

        StopWatch watch = new StopWatch();
        watch.start();
        baseballRankingRepository.increaseWin("kia");
        watch.stop();

        BaseballTeam updateKia = baseballRankingRepository.findOneByTeam("kia");
        assertEquals((kia.getWin() + 1), updateKia.getWin());
        logger.info("Time: " + watch.getTotalTimeSeconds());
    }

    @Test
    public void increaseDrawTest() {
        BaseballTeam kia = baseballRankingRepository.findOneByTeam("kia");

        StopWatch watch = new StopWatch();
        watch.start();
        baseballRankingRepository.increaseDraw("kia");
        watch.stop();

        BaseballTeam updateKia = baseballRankingRepository.findOneByTeam("kia");
        assertEquals((kia.getDraw() + 1), updateKia.getDraw());
        logger.info("Time: " + watch.getTotalTimeSeconds());
    }

    @Test
    public void increaseLoseTest() {
        BaseballTeam kia = baseballRankingRepository.findOneByTeam("kia");

        StopWatch watch = new StopWatch();
        watch.start();
        baseballRankingRepository.increaseLose("kia");
        watch.stop();

        BaseballTeam updateKia = baseballRankingRepository.findOneByTeam("kia");
        assertEquals((kia.getLose() + 1), updateKia.getLose());
        logger.info("Time: " + watch.getTotalTimeSeconds());
    }
}
