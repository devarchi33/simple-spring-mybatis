package com.skyfly33.spring.restclient;

import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by donghoon on 15. 8. 31..
 */
@Component
public class KakaoPushMessageSend {

    Logger logger = LoggerFactory.getLogger(KakaoPushMessageSend.class);

    @Autowired
    private URIBuilder builder;
    @Autowired
    private Utils utils;
    @Autowired
    private HttpPost httpPost;

    private String uuid = Config.getInstance().getProperties("uuid");
    private String adminKey = Config.getInstance().getProperties("adminKey");

    private URI getUri() {
        URI uri = null;
        try {
            builder.setScheme("https");
            builder.setHost("kapi.kakao.com");
            builder.setPath("/v1/push/send");
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    private ArrayList<NameValuePair> setMessage(String message) {
        // Setup the request parameters
        ArrayList<NameValuePair> postParameters;
        JSONArray uuids = new JSONArray();
        uuids.add(uuid);
        JSONObject customMessageObject = new JSONObject();
        customMessageObject.put("message", message);
        JSONObject messageObject = new JSONObject();
        messageObject.put("custom_field", customMessageObject);
        messageObject.put("return_url", "skyfly33.dothome.co.kr/kakao/kakaologindemo.html");
        JSONObject gcmMessage = new JSONObject();
        gcmMessage.put("for_gcm", messageObject);

        postParameters = new ArrayList<NameValuePair>(4);
        postParameters.add(new BasicNameValuePair("uuids", uuids.toJSONString()));
        System.out.println("message : " + messageObject.toJSONString());
        postParameters.add(new BasicNameValuePair("push_message", gcmMessage.toJSONString()));
        return postParameters;
    }

    public void sendMessage(String message) {
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            httpPost.setURI(getUri());
            httpPost.setHeader("Authorization", adminKey);
            logger.info("executing request : " + httpPost.getURI());

            httpPost.setEntity(new UrlEncodedFormEntity(setMessage(message)));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            System.out.println("---------------------------------------- push message send start ----------------------------------------");
            // 응답 결과
            logger.info(response.getStatusLine().toString());
            if (entity != null) {
                logger.info("Response content length : " + entity.getContentLength());
                logger.info("Reponse Content-type : " + entity.getContentType());
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                }
            }
            httpPost.abort();
            System.out.println("---------------------------------------- push message send end ----------------------------------------\n");
        } catch (Exception e) {
            //ClientProtocolException, IOException, URISyntaxException
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
}