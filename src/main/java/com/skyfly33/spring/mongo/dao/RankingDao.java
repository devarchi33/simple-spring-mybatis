package com.skyfly33.spring.mongo.dao;

import com.mongodb.WriteResult;
import com.skyfly33.spring.domain.BaseballTeam;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 13..
 */
public interface RankingDao {

    List<?> findAllTeam();

    BaseballTeam findOneByTeam(String team);

    Integer increaseTheNumberOfGame(String team);

    Integer increaseWin(String team);

    Integer increaseDraw(String team);

    Integer increaseLose(String team);

    WriteResult updateWinningRate(String team, String winningRate);

    List<?> sortTeamByField(String field);

    WriteResult updateGameBehind(String team, String gameBehind);

    WriteResult updateRecentTenGame(String team, Object... recentTenGame);
}
