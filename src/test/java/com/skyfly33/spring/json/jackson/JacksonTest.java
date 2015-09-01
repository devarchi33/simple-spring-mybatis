package com.skyfly33.spring.json.jackson;

/**
 * Created by donghoon on 15. 9. 2..
 */

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.skyfly33.spring.json.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonTest {

    Logger logger = LoggerFactory.getLogger(JacksonTest.class);

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper(); // 재사용 가능하고 전체코드에서 공유함.
            String user_json = "{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" }, " + " \"gender\" : \"MALE\", " + " \"verified\" : false, "
                    + " \"userImage\" : \"Rm9vYmFyIQ==\" " + "}";
            User user = mapper.readValue(user_json, User.class);
            logger.info("First name : " + user.getName().getFirst());
            logger.info("Last name : " + user.getName().getLast());
            logger.info("Gender : " + user.getGender());
            logger.info("Verified : " + user.isVerified());
            user.getName().setFirst("ChangeJoe");
            user.getName().setLast("ChangeSixpack");
            String jsonStr = mapper.writeValueAsString(user);
            logger.info("Simple Binding : " + jsonStr);
            //직접 raw 데이터를 입력해서 JSON형태로 출력하는 방법.
            Map<String, Object> userData = new HashMap<String, Object>();
            Map<String, String> nameStruct = new HashMap<String, String>();
            nameStruct.put("first", "RawJoe");
            nameStruct.put("last", "Sixpack");
            userData.put("name", nameStruct);
            userData.put("gender", "MALE");
            userData.put("verified", Boolean.FALSE);
            userData.put("userImage", "Rm9vYmFyIQ==");
            jsonStr = mapper.writeValueAsString(userData);
            logger.info("Raw Data : " + jsonStr);
            //Tree 모델 예제
            ObjectMapper m = new ObjectMapper();
            // mapper.readTree(source), mapper.readValue(source, JsonNode.class); 둘중 하나 사용가능.
            JsonNode rootNode = m.readTree(user_json);
            JsonNode nameNode = rootNode.path("name");
            String lastName = nameNode.path("last").textValue();
            ((ObjectNode) nameNode).put("last", "inputLast");
            jsonStr = m.writeValueAsString(rootNode);
            logger.info("Tree Model : " + jsonStr);
            //Streaming API 예제
            JsonFactory f = new JsonFactory();
            OutputStream outStr = System.out;
            JsonGenerator g = f.createJsonGenerator(outStr);
            g.writeStartObject();
            g.writeObjectFieldStart("name");
            g.writeStringField("first", "StreamAPIFirst");
            g.writeStringField("last", "Sixpack");
            g.writeEndObject(); // 'name' 필드용.
            g.writeStringField("gender", "MALE");
            g.writeBooleanField("verified", false);
            g.writeFieldName("userImage");
            g.writeEndObject();
            g.close(); // 사용한 다음 close해줘서 output에 있는 내용들을 flush해야함.
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
