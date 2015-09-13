package com.skyfly33.spring.mongo.repository;

import com.mongodb.WriteResult;
import com.skyfly33.spring.controller.BaseballController;
import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.RankingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by donghoon on 15. 9. 13..
 */
@Repository("rankingRepository")
public class BaseballRankingRepository implements RankingDao {

    private final Logger logger = LoggerFactory.getLogger(BaseballRankingRepository.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    private final String pattern = "#.###";
    private DecimalFormat decimalFormat = new DecimalFormat(pattern);


    @Override
    public List<BaseballTeam> getAll() {
        return mongoTemplate.findAll(BaseballTeam.class);
    }

    @Override
    public BaseballTeam findOneByTeam(String team) {
        Query query = query(where("team").is(team));
        return mongoTemplate.findOne(query, BaseballTeam.class);
    }

    @Override
    public Integer increaseTheNumberOfGame(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("the_number_of_game", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return updateTeam.getThe_number_of_game();
    }

    @Override
    public Integer increaseWin(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("win", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return updateTeam.getWin();
    }

    @Override
    public Integer increaseDraw(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("draw", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return updateTeam.getThe_number_of_game();
    }

    @Override
    public Integer increaseLose(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("lose", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        increaseTheNumberOfGame(team);
        updateWinningRate(team);
        return updateTeam.getThe_number_of_game();
    }

    @Override
    public WriteResult updateWinningRate(String team) {
        BaseballTeam findTeam = findOneByTeam(team);
        String winningRate = decimalFormat.format(findTeam.getWin() / (double) (findTeam.getThe_number_of_game() - findTeam.getDraw()));
        Query query = query(where("team").is(team));
        Update update = new Update().set("winning_rate", winningRate);
        return mongoTemplate.upsert(query, update, BaseballTeam.class);
    }


}