package com.skyfly33.spring.mongo.model.whoo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 15. 9. 2..
 */
@Document(collection = "user")
@Data
public class User {

    @Id
    private long uuid;
    private String name;
    private String email;
    @DBRef
    private ExternalAccount externalAccount;
    @DBRef
    private Server server;

    @Document(collection = "server")
    @Data
    public class Server {
        @Id
        private String Id;
        private String server_name;
        private String ip;
        private int condition; //0: 승인요청, 1: 승인, 2: 정상.
        private long uuid;
        @DBRef
        private Receiver receiver;

        @Document(collection = "receiver")
        @Data
        public class Receiver {
            @Id
            private long uuid;
            @DBRef
            private ExternalAccount externalAccount;
            private String pushToken;
            private String deviceToken;
        }
    }
}
