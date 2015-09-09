package com.skyfly33.spring.pubsub;

import com.skyfly33.spring.helper.JedisHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

public class Program {

    private static final Logger logger = LoggerFactory.getLogger(Program.class);

    private static final JedisHelper helper = JedisHelper.getInstance();
    private static final Jedis subscriberJedis = helper.getConnection();
    private static final Subscriber subscriber = new Subscriber();
    private static final String CHANNEL_NAME = "testchannel";

    public static void main(String[] args) throws Exception {
        Program pr = new Program();

        pr.createSubscriber(CHANNEL_NAME);

        final Jedis publisherJedis = helper.getConnection();

        new Publisher(publisherJedis, CHANNEL_NAME).start();

        subscriber.unsubscribe();
        helper.returnResource(subscriberJedis);
        helper.returnResource(publisherJedis);
    }

    public void createSubscriber(final String channelName) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    logger.info("Subscribing to \"" + channelName + "\". This thread will be blocked.");
                    subscriberJedis.subscribe(subscriber, channelName);
                    logger.info("Subscription ended.");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("Subscribing failed." + e);
                }
            }
        }).start();
    }
}