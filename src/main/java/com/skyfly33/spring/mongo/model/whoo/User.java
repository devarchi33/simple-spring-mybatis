package com.skyfly33.spring.mongo.model.whoo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 2..
 */
@Document(collection = "whooUser")
public class User {

    private String name;
    private String email;
    @DBRef
    private ExternalAccount externalAccount;
    private List<Server> server;

    @Document(collection = "whooServer")
    public class Server {
        @Id
        private long Id;
        private String server_name;
        private String host_name;
        private String ip;
        private int condition; //0: 승인요청, 1: 승인, 2: 정상.
        @DBRef
        private Recipient recipient;

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public String getServer_name() {
            return server_name;
        }

        public void setServer_name(String server_name) {
            this.server_name = server_name;
        }

        public String getHost_name() {
            return host_name;
        }

        public void setHost_name(String host_name) {
            this.host_name = host_name;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getCondition() {
            return condition;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        public Recipient getRecipient() {
            return recipient;
        }

        public void setRecipient(Recipient recipient) {
            this.recipient = recipient;
        }

        @Document(collection = "whooRecipient")
        public class Recipient {
            @Id
            private long uuid;
            @DBRef
            private ExternalAccount externalAccount;
            private String pushToken;

            public long getUuid() {
                return uuid;
            }

            public void setUuid(long uuid) {
                this.uuid = uuid;
            }

            public ExternalAccount getExternalAccount() {
                return externalAccount;
            }

            public void setExternalAccount(ExternalAccount externalAccount) {
                this.externalAccount = externalAccount;
            }

            public String getPushToken() {
                return pushToken;
            }

            public void setPushToken(String pushToken) {
                this.pushToken = pushToken;
            }
        }
    }
}
