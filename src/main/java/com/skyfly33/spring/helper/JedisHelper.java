package com.skyfly33.spring.helper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JedisHelper {

    private static Config tConfig = Config.getInstance();
    private static final String REDIS_HOST = tConfig.getProperties("redis.host");
    private static final int REDIS_PORT = Integer.parseInt(tConfig.getProperties("redis.port"));
    private Set<Jedis> connectionList = new HashSet<>();
    private JedisPool pool = null;

    private JedisHelper() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setBlockWhenExhausted(true);

        this.pool = new JedisPool(config, REDIS_HOST, REDIS_PORT, 5000);
    }

    private static class LazyHolder {
        private static final JedisHelper INSTANCE = new JedisHelper();
    }

    public static JedisHelper getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Jedis getConnection() {
        Jedis jedis = this.pool.getResource();
        connectionList.add(jedis);

        return jedis;
    }

    public void returnResource(Jedis jedis) {
        this.pool.returnResourceObject(jedis);
    }

    public void destroyPool() {
        Iterator<Jedis> jedisList = connectionList.iterator();
        while (jedisList.hasNext()) {
            Jedis jedis = jedisList.next();
            this.pool.returnResourceObject(jedis);
        }

        this.pool.destroy();
    }
}
