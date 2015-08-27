package com.skyfly33.spring.mongo.service.impl;

import com.skyfly33.spring.mongo.dao.DocumentDao;
import com.skyfly33.spring.mongo.model.Document;
import com.skyfly33.spring.mongo.model.Type;
import com.skyfly33.spring.mongo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentDao documentDao;

    @Override
    public List<Document> getAllDocuments() {
        return documentDao.getAll();
    }

    @Override
    public Document findDocumentById(String id) {
        return documentDao.findById(id);
    }

    @Override
    public Document saveDocument(String id, Document document) {
        return documentDao.save(id, document);
    }

    @Override
    public Document removeDocumentById(String id) {
        return documentDao.removeById(id);
    }

    @Override
    public List<Document> findByType(Type type) {
        return documentDao.findByTypeName(type.getName());
    }

    @Override
    public boolean updateLocationFromDocumentId(String documentId, String location) {
        Document document = documentDao.findById(documentId);
        if (null == document)
            return false;
        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }
}
