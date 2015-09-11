package com.skyfly33.spring.mongo.model.whoo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 15. 9. 2..
 */
@Document(collection = "externalAccount")
@Data
public class ExternalAccount {
    @Id
    private Long uuid;
    private String type;
    private String nickname;
    private String thumbnailImg;
}
