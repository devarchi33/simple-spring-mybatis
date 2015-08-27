package com.skyfly33.spring.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.skyfly33.spring.mongo.dao.DocumentDao;
import com.skyfly33.spring.mongo.dao.TypeDao;
import com.skyfly33.spring.mongo.model.Document;
import com.skyfly33.spring.mongo.model.Type;
import com.skyfly33.spring.mongo.service.DocumentService;
import com.skyfly33.spring.mongo.service.TypeService;
import jdk.internal.dynalink.linker.TypeBasedGuardingDynamicLinker;
import org.junit.Ignore;
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
@ContextConfiguration(locations = {"/mongoApplicationContext.xml"})
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
}