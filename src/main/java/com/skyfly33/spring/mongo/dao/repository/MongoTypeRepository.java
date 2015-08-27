package com.skyfly33.spring.mongo.dao.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.skyfly33.spring.mongo.dao.TypeDao;
import com.skyfly33.spring.mongo.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
@Repository("mongoTypeRepository")
public class MongoTypeRepository implements TypeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Type> getAll() {
        return mongoTemplate.findAll(Type.class);
    }

    @Override
    public Type findById(String id) {
        Query query = query(where("typeId").is(id));
        return mongoTemplate.findOne(query, Type.class);
    }

    @Override
    public Type save(Type type) {
        mongoTemplate.insert(type);
        return type;
    }
}
