package com.ftiger.www.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author 宋旭源
 */
@Configuration
@EnableRedisRepositories(basePackages = "com.ftiger.www.game.redis.dao")
@MapperScan("com.ftiger.www.game.mysql")
public class ApplicationConfig {
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    return new JedisConnectionFactory();
  }

}
