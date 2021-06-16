package my.redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: YST
 * @Date: 2021/4/24 14:53
 * @Version: 1.0
 * @Description: redission配置
 */
@Configuration
@ConfigurationProperties(prefix="redis")
public class RedisConfig {

    Map<String,String> redisMap;

    /**
     * redisson bean 配置
     * 数据库1
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown", value = "1")
    @Scope("prototype")
    RedissonClient redissonData1() throws IOException {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://"+redisMap.get("host")+":"+redisMap.get("port"));
        singleServerConfig.setPassword(redisMap.get("password"));
        singleServerConfig.setConnectionPoolSize(Integer.parseInt(redisMap.get("max-active")));
        singleServerConfig.setTimeout(Integer.parseInt(redisMap.get("timeout")));
        singleServerConfig.setConnectionMinimumIdleSize(Integer.parseInt(redisMap.get("min-idle")));
        singleServerConfig.setIdleConnectionTimeout(Integer.parseInt(redisMap.get("max-wait")));
        singleServerConfig.setDatabase(1);
        return Redisson.create(config);
    }
    /**
     * redisson bean 配置
     * 数据库2
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown", value = "1")
    @Scope("prototype")
    RedissonClient redissonData2() throws IOException {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://"+redisMap.get("host")+":"+redisMap.get("port"));
        singleServerConfig.setPassword(redisMap.get("password"));
        singleServerConfig.setConnectionPoolSize(Integer.parseInt(redisMap.get("max-active")));
        singleServerConfig.setTimeout(Integer.parseInt(redisMap.get("timeout")));
        singleServerConfig.setConnectionMinimumIdleSize(Integer.parseInt(redisMap.get("min-idle")));
        singleServerConfig.setIdleConnectionTimeout(Integer.parseInt(redisMap.get("max-wait")));
        singleServerConfig.setDatabase(2);
        return Redisson.create(config);
    }
    /**
     * redisson bean 配置
     * 数据库3
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod = "shutdown", value = "1")
    @Scope("prototype")
    RedissonClient redissonData3() throws IOException {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://"+redisMap.get("host")+":"+redisMap.get("port"));
        singleServerConfig.setPassword(redisMap.get("password"));
        singleServerConfig.setConnectionPoolSize(Integer.parseInt(redisMap.get("max-active")));
        singleServerConfig.setTimeout(Integer.parseInt(redisMap.get("timeout")));
        singleServerConfig.setConnectionMinimumIdleSize(Integer.parseInt(redisMap.get("min-idle")));
        singleServerConfig.setIdleConnectionTimeout(Integer.parseInt(redisMap.get("max-wait")));
        singleServerConfig.setDatabase(3);
        return Redisson.create(config);
    }

}
