package com.skyfly33.spring.mongo.repository;

import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.RankingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by donghoon on 15. 9. 13..
 */
@Repository("rankingRepository")
public class BaseballRankingRepository implements RankingDao {

    Logger logger = LoggerFactory.getLogger(BaseballRankingRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;


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
    public int increaseTheNumberOfGame(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("the_number_of_game", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return updateTeam.getThe_number_of_game();
    }

    @Override
    public int increaseWin(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("win", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return updateTeam.getWin();
    }

    @Override
    public int increaseDraw(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("draw", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return updateTeam.getThe_number_of_game();
    }

    @Override
    public int increaseLose(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("lose", 1);
        BaseballTeam updateTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return updateTeam.getThe_number_of_game();
    }


}