package com.skyfly33.spring.restclient.onesignal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyfly33.spring.helper.Config;
import com.skyfly33.spring.helper.Utils;
import com.skyfly33.spring.mongo.model.onesignal.Message;
import com.skyfly33.spring.mongo.model.onesignal.Notification;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EncodingUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by donghoon on 15. 9. 3..
 */
@Component
public class OneSignalCreateNotification {

    Logger logger = LoggerFactory.getLogger(OneSignalCreateNotification.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    Utils utils;
    @Autowired
    private URIBuilder builder;
    @Autowired
    private HttpPost httpPost;

    private String one_signal_rest_api_key = Config.getInstance().getProperties("one_signal_rest_api_key");
    private String one_signal_app_id = Config.getInstance().getProperties("one_signal_app_id");
    private final String URI = "https://onesignal.com/api/v1/notifications";

    public String createNotification() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        headers.add("Authorization", "Basic " + "MDYxZTBiNmMtNGViYi0xMWU1LTllOTUtMWI4YTZiNGQzMmMw");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        JSONObject messageParam = messageBuilder(one_signal_app_id, "Message by Spring Resttemplate", "ALL");
        logger.info("Message Param: " + messageParam);

//        byte[] rawMessageParam = EncodingUtils.getBytes(messageParam, "utf-8");
        String stringMessageParam = messageParam.toJSONString();

//        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(messageParam, headers);
        HttpEntity<String> requestEntity = new HttpEntity<>(stringMessageParam, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, String.class);
        HttpStatus status = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        String responseBody = responseEntity.getBody();

        logger.info(status.toString());
        logger.info(responseHeaders.toString());
        logger.info(responseBody);

        return status.toString();
    }

    public String createNotificationByApache() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            httpPost.setURI(getUri());
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
//            httpPost.setHeader("Accept", "application/json;charset=utf-8");
            httpPost.setHeader("Authorization", one_signal_rest_api_key);
            logger.info("executing request : " + httpPost.getURI());

            httpPost.setEntity(new UrlEncodedFormEntity(setMessage(one_signal_app_id, "Message-by-Apache-HtttpClient!")));

            HttpResponse response = httpClient.execute(httpPost);
            org.apache.http.HttpEntity entity = response.getEntity();

            System.out.println("---------------------------------------- push message send start ----------------------------------------");
            // 응답 결과
            logger.info(response.getStatusLine().toString());
            if (entity != null) {
                logger.info("Response content length : " + entity.getContentLength());
                logger.info("Reponse Content-type : " + entity.getContentType());
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line = "";
                while ((line = rd.readLine()) != null) {
                    logger.info(line);
                }
            }
            httpPost.abort();
            System.out.println("---------------------------------------- push message send end ----------------------------------------\n");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createnotificationByJDK() {
        String contents = "{ " +
                "\"app_id\"            : \"" + one_signal_app_id + "\", " +
                "\"contents\"            : {\"en\" : \"test message by JDK\"}, " +
                "\"included_segments\" : [ \"All\" ] " +
                "}";

        String method = "POST";
        String contentType = "application/json";

        try {
            URL u = new URL(URI);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", contentType);
            conn.setRequestProperty("Content-Length", "" + contents.length());
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestProperty("Authorization", "Basic " + "MDYxZTBiNmMtNGViYi0xMWU1LTllOTUtMWI4YTZiNGQzMmMw");


            OutputStream os = conn.getOutputStream();
            DataOutputStream wr = new DataOutputStream(os);
            wr.writeBytes(contents);
            wr.flush();
            wr.close();


            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private java.net.URI getUri() {
        URI uri = null;
        try {
            builder.setScheme("https");
            builder.setHost("onesignal.com/");
            builder.setPath("/api/v1/notifications");
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    private JSONObject messageBuilder(String app_id, String enMessage, String segment) {
        try {
            JSONObject json = new JSONObject();
            json.put("app_id", app_id);
            List<String> included_segments = new ArrayList<>();
            included_segments.add(segment);
            JSONObject contents = new JSONObject();
            contents.put("en", enMessage);
            json.put("contens", contents);

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<NameValuePair> setMessage(String app_id, String enMessage) {
        // Setup the request parameters
        ArrayList<NameValuePair> postParameters;
        JSONObject contents = new JSONObject();
        contents.put("en", enMessage);

        postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("app_id", app_id));
        postParameters.add(new BasicNameValuePair("contents", contents.toJSONString()));
        return postParameters;
    }
}
