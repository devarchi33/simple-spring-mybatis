package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.Document;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface DocumentDao {
    public List<Document> getAll();

    public Document save(String id, Document document);

    public Document findById(String id);

    public Document removeById(String id);

    public List<Document> findByTypeName(String name);
}
