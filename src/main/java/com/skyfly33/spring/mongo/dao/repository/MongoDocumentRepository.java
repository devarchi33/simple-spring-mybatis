package com.skyfly33.spring.mongo.dao.repository;

import com.skyfly33.spring.mongo.dao.DocumentDAO;
import com.skyfly33.spring.mongo.model.Document;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public class MongoDocumentRepository implements DocumentDAO {
    @Override
    public List<Document> getAll() {
        return null;
    }

    @Override
    public Document save(String id, Document document) {
        return null;
    }

    @Override
    public Document findById(String id) {
        return null;
    }

    @Override
    public Document removeById(String id) {
        return null;
    }

    @Override
    public List<Document> findByTypeName(String name) {
        return null;
    }
}
