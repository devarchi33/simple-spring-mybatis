package com.skyfly33.spring.mongo.dao.smaple.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.skyfly33.spring.mongo.dao.smaple.DocumentDao;
import com.skyfly33.spring.mongo.model.sample.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
@Repository("mongoDocumentRepository")
public class MongoDocumentRepository implements DocumentDao {

    Logger logger = LoggerFactory.getLogger(MongoDocumentRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Document> getAll() {
        return mongoTemplate.findAll(Document.class);
    }

    @Override
    public Document save(String id, Document document) {
        Document _documentUpdate = findById(id);
        if (_documentUpdate == null) {
            mongoTemplate.insert(document);
        } else {
            Query query = query(where("documentId").is(id));
            Update update = new Update();
            update.set("name", null == document.getName() ? _documentUpdate.getName() : document.getName());
            update.set("location", null == document.getLocation() ? _documentUpdate.getLocation() : document.getLocation());
            update.set("description", null == document.getDescription() ? _documentUpdate.getDescription() : document.getDescription());
            update.set("type", null == document.getType() ? _documentUpdate.getType() : document.getType());
            update.set("modified", new Date());
            mongoTemplate.updateFirst(query, update, Document.class);
            document = findById(id);
        }
        return document;
    }

    @Override
    public Document findById(String id) {
        logger.debug(id);
        Query query = query(where("documentId").is(id));
        logger.debug(query.toString());
        return mongoTemplate.findOne(query, Document.class);
    }

    @Override
    public Document removeById(String id) {
        Document document = findById(id);
        if (document != null)
            mongoTemplate.remove(document);
        return document;
    }

    @Override
    public List<Document> findByTypeName(String name) {
        Query query = query(where("documentId.name.type").is(name));
        return mongoTemplate.find(query, Document.class);
    }
}
