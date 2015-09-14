package com.skyfly33.spring.mongo.service.impl;

import com.mongodb.WriteResult;
import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.dao.repository.BaseballRankingRepository;
import com.skyfly33.spring.mongo.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by donghoon on 15. 9. 13..
 */
@Service
public class BaseballRankingService implements RankingService {

    @Autowired
    private BaseballRankingRepository baseballRankingRepository;
    private String pattern = "#.###";
    private DecimalFormat decimalFormat = new DecimalFormat(pattern);
    private String pattern2 = "#.#";
    private DecimalFormat decimalFormat2 = new DecimalFormat(pattern2);

    @Override
    public Integer increaseWin(String team) {
        int win = baseballRankingRepository.increaseWin(team);
        baseballRankingRepository.increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return win;
    }

    @Override
    public Integer increaseDraw(String team) {
        int draw = baseballRankingRepository.increaseDraw(team);
        baseballRankingRepository.increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return draw;
    }

    @Override
    public Integer increaseLose(String team) {
        int lose = baseballRankingRepository.increaseLose(team);
        baseballRankingRepository.increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return lose;
    }

    @Override
    public WriteResult updateWinningRate(String team) {
        BaseballTeam findTeam = baseballRankingRepository.findOneByTeam(team);
        String winningRate = decimalFormat.format(findTeam.getWin() / (double) (findTeam.getThe_number_of_game() - findTeam.getDraw()));
        return baseballRankingRepository.updateWinningRate(team, winningRate);
    }

    @Override
    public List<BaseballTeam> sortTeamByField(String field) {
        return baseballRankingRepository.sortTeamByField(field);
    }

    @Override
    public WriteResult updateGameBehind(String team) {
        List<BaseballTeam> teamList = baseballRankingRepository.sortTeamByField("winning_rate");
        BaseballTeam first = teamList.get(0);
        BaseballTeam behindTeam = baseballRankingRepository.findOneByTeam(team);
        String gameBehind = decimalFormat2.format((double) ((first.getWin() - behindTeam.getWin()) + (behindTeam.getLose() - first.getLose())) / 2);
        return baseballRankingRepository.updateGameBehind(team, gameBehind);
    }
}