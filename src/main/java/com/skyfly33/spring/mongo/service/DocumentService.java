package com.skyfly33.spring.mongo.service;

import com.skyfly33.spring.mongo.model.Document;
import com.skyfly33.spring.mongo.model.Type;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface DocumentService {

    public List<Document> getAllDocuments();

    public Document findDocumentById(String id);

    public Document saveDocument(String id, Document document);

    public Document removeDocumentById(String id);

    public List<Document> findByType(Type type);

    public boolean updateLocationFromDocumentId(String documentId, String location);
}
