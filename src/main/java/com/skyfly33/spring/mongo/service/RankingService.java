package com.skyfly33.spring.mongo.service;

import com.mongodb.WriteResult;

/**
 * Created by donghoon on 15. 9. 13..
 */
public interface RankingService {

    Integer increaseWin(String team);

    Integer increaseDraw(String team);

    Integer increaseLose(String team);

    WriteResult updateWinningRate(String team);
}
