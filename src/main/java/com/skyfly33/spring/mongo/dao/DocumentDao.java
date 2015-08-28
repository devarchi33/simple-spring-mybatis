package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.sample.Document;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface DocumentDao {
    List<Document> getAll();

    Document save(String id, Document document);

    Document findById(String id);

    Document removeById(String id);

    List<Document> findByTypeName(String name);
}
