package com.skyfly33.spring.mongo.dao.repository;

import com.mongodb.WriteResult;
import com.skyfly33.spring.domain.BaseballTeam;
import com.skyfly33.spring.mongo.dao.RankingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    private final Logger logger = LoggerFactory.getLogger(BaseballRankingRepository.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private Query query;

    @Override
    public List<BaseballTeam> findAllTeam() {
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
        BaseballTeam originalTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return originalTeam.getThe_number_of_game() + 1;
    }

    @Override
    public Integer increaseWin(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("win", 1);
        BaseballTeam originalTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return originalTeam.getWin() + 1;
    }

    @Override
    public Integer increaseDraw(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("draw", 1);
        BaseballTeam originalTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return originalTeam.getDraw() + 1;
    }

    @Override
    public Integer increaseLose(String team) {
        Query query = query(where("team").is(team));
        Update update = new Update().inc("lose", 1);
        BaseballTeam originalTeam = mongoTemplate.findAndModify(query, update, BaseballTeam.class);
        return originalTeam.getLose() + 1;
    }

    @Override
    public WriteResult updateWinningRate(String team, String winningRate) {
        Query query = query(where("team").is(team));
        Update update = new Update().set("winning_rate", winningRate);
        return mongoTemplate.upsert(query, update, BaseballTeam.class);
    }

    @Override
    public List<BaseballTeam> sortTeamByField(String field) {
        query.limit(10);
        query.with(new Sort(Sort.Direction.DESC, field));
        return mongoTemplate.find(query, BaseballTeam.class);
    }

    @Override
    public WriteResult updateGameBehind(String team, String gameBehind) {
        Query query = query(where("team").is(team));
        Update update = new Update().set("game_behind", gameBehind);
        return mongoTemplate.upsert(query, update, BaseballTeam.class);
    }


}