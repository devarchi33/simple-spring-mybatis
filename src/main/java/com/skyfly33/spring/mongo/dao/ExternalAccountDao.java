package com.skyfly33.spring.mongo.dao;

        import com.skyfly33.spring.mongo.model.whoo.ExternalAccount;

        import java.util.List;

/**
 * Created by donghoon on 15. 9. 8..
 */
public interface ExternalAccountDao {
    List<ExternalAccount> getAll();

    ExternalAccount findOneById(Long id);

    boolean save(ExternalAccount externalAccount);
}
