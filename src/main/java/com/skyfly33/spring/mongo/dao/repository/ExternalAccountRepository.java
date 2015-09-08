package com.skyfly33.spring.mongo.dao.repository;

import com.skyfly33.spring.mongo.dao.ExternalAccountDao;
import com.skyfly33.spring.mongo.model.whoo.ExternalAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by donghoon on 15. 9. 8..
 */
@Repository("externalAccountRepository")
public class ExternalAccountRepository implements ExternalAccountDao {

    Logger logger = LoggerFactory.getLogger(ExternalAccountRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<ExternalAccount> getAll() {
        return mongoTemplate.findAll(ExternalAccount.class);
    }

    @Override
    public ExternalAccount findOneById(Long id) {
        Query query = query(where("uuid").is(id));
        return mongoTemplate.findOne(query, ExternalAccount.class);
    }

    @Override
    public boolean save(ExternalAccount externalAccount) {
        try {
            mongoTemplate.insert(externalAccount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
