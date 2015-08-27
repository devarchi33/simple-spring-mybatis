package com.skyfly33.spring.mongo.service;

import com.skyfly33.spring.mongo.model.sample.Document;
import com.skyfly33.spring.mongo.model.sample.Type;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface DocumentService {

    List<Document> getAllDocuments();

    Document findDocumentById(String id);

    Document saveDocument(String id, Document document);

    Document removeDocumentById(String id);

    List<Document> findByType(Type type);

    boolean updateLocationFromDocumentId(String documentId, String location);
}
