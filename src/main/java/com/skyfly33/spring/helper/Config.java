package com.skyfly33.spring.helper;


/**
 * Created by donghoon on 15. 8. 31..
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component
public class Config {

    private final Logger logger = LoggerFactory.getLogger(Config.class);

    private static Properties prop;
    private static String configFile = "./whoo.properties";

    private Config() {

        prop = new Properties();
        File src = new File(configFile);

        if (!src.exists()) {
            logger.debug("Can't find config file...");
        } else {
            InputStream in = null;

            try {
                in = new FileInputStream(src);
                prop.load(in);
            } catch (FileNotFoundException e) {
                // TODO: handle exception
                logger.debug("Can't find config file...");
            } catch (IOException e) {
                logger.debug("Can't load config file...");
            } finally {
                try {
                    if (in != null)
                        in.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }


    private static class LazyHolder {
        private static final Config INSTANCE = new Config();
    }

    public static Config getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperties(String key) {
        return (String) prop.get(key);
    }
}