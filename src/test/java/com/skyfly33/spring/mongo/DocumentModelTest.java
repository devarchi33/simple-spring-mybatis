package com.skyfly33.spring.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.skyfly33.spring.mongo.dao.smaple.DocumentDao;
import com.skyfly33.spring.mongo.dao.smaple.TypeDao;
import com.skyfly33.spring.mongo.model.sample.Document;
import com.skyfly33.spring.mongo.model.sample.Type;
import com.skyfly33.spring.mongo.service.DocumentService;
import com.skyfly33.spring.mongo.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donghoon on 15. 8. 27..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/mongoApplicationContext.xml"})
public class DocumentModelTest {

    private static final Logger logger = LoggerFactory.getLogger(DocumentModelTest.class);
    private static final String ID = "1acbb68a-a859-49c9-ac88-d9e9322bac55";
    private static final String NAME = "Book Template";
    private static final String NAME_UPDATED = "skyfly33 Book";

    @Autowired
    DocumentDao mongoDocDao;
    @Autowired
    TypeDao mongoTypeDao;
    @Autowired
    DocumentService documentService;
    @Autowired
    TypeService typeService;

    @Test
//    @Ignore
    public void testMongoDBMigration() {
        logger.debug("Testing Spring Data MongoDB - Migration (Run only once)...");
        assertNotNull(mongoDocDao);
        assertNotNull(mongoTypeDao);
        assertNotNull(documentService);
        assertNotNull(typeService);

        List<Type> types = typeService.getAllDefinedTypes();
//        Type type1 = types.get(0);
//        logger.debug(type1.toString());
        assertNotNull(types);
        assertEquals(4, types.size());

        for (Type type : types) {
            mongoTypeDao.save(type);
        }

        List<Document> documents = documentService.getAllDocuments();
        assertNotNull(documents);
        assertEquals(6, documents.size());

        for (Document document : documents) {
            mongoDocDao.save(document.getDocumentId(), document);
        }
    }

    @Test
//    @Ignore
    public void testMongoDBFind() {
        logger.debug("Testing Spring Data MongoDB... [ FIND ]");
        assertNotNull(mongoDocDao);
        Document document = mongoDocDao.findById(ID);
        assertNotNull(document);
        assertEquals(NAME, document.getName());
        logger.debug(document.toString());
    }
}