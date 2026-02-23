package com.redislabs.university.RU102J.dao;

import com.redislabs.university.RU102J.core.KeyHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.UUID;

public class RateLimiterSlidingDaoRedisImpl implements RateLimiter {

    private final JedisPool jedisPool;
    private final long windowSizeMS;
    private final long maxHits;

    public RateLimiterSlidingDaoRedisImpl(JedisPool pool, long windowSizeMS,
                                          long maxHits) {
        this.jedisPool = pool;
        this.windowSizeMS = windowSizeMS;
        this.maxHits = maxHits;
    }

    // Challenge #7
    @Override
    public void hit(String name) throws RateLimitExceededException {
        // START CHALLENGE #7
        try (Jedis jedis = jedisPool.getResource()) {
            Pipeline pipeline = jedis.pipelined();
            String key = KeyHelper.getKey(name);
            long score = System.currentTimeMillis();
            pipeline.zadd(key, score, UUID.randomUUID().toString());
            pipeline.zrevrangeWithScores(key, score - windowSizeMS, score);
            pipeline.sync();
            Long totalHits = jedis.zcard(key);
            if (totalHits > maxHits) {
                throw new RateLimitExceededException();
            }
            // END CHALLENGE #7
        }
    }
}

