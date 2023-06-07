package my.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/5/25 14:25
 * @description:
 */
public class RedisLock {

    private static RedisTemplate<String,String> redisTemplate;


    public static void main(String[] args) {


        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "1", 10, TimeUnit.SECONDS);


    }

}
