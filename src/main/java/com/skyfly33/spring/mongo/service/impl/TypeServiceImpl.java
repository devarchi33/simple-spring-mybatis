package com.skyfly33.spring.mongo.service.impl;

import com.skyfly33.spring.mongo.dao.TypeDao;
import com.skyfly33.spring.mongo.model.sample.Type;
import com.skyfly33.spring.mongo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public void createNewType(Type type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateType(Type type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void removeTypeById(String id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Type> getAllDefinedTypes() {
        return typeDao.getAll();
    }

    @Override
    public Type getTypeById(String id) {
        return typeDao.findById(id);
    }
}
