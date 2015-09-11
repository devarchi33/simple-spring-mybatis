package com.skyfly33.spring.mongo.dao.repository;

import com.skyfly33.spring.mongo.dao.ServerDao;
import com.skyfly33.spring.mongo.model.whoo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by donghoon on 15. 9. 11.
 */
@Repository("serverRepository")
public class ServerRepository implements ServerDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<User.Server> getAll() {
        return mongoTemplate.findAll(User.Server.class);
    }

    @Override
    public User.Server findOneById(Long uuid) {
        Query query = query(where("uuid").is(uuid));
        return mongoTemplate.findOne(query, User.Server.class);
    }

    @Override
    public boolean save(User.Server server) {
        try {
            mongoTemplate.insert(server);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
