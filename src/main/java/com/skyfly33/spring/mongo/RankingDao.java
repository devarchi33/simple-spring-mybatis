package com.skyfly33.spring.mongo;

import com.skyfly33.spring.domain.BaseballTeam;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 13..
 */
public interface RankingDao {

    List<?> getAll();

    BaseballTeam findOneByTeam(String team);

    int increaseWin(String team);
}
