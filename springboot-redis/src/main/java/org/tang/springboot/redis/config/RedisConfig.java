package org.tang.springboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.tang.springboot.redis.entity.User;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   配置针对于User的RedisTemplate
 */
@Configuration
public class RedisConfig {

	/**
	 * 获取redis连接工厂对象
	 * @return
	 */
	@Bean
	public  JedisConnectionFactory JedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	/**
	 * 获取指定类型的redisTemplate
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory){
		  RedisTemplate<String, User> template = new RedisTemplate<>();
		  //设置连接工厂属性
		  template.setConnectionFactory(factory);
		  //设置键序列化属性
		  template.setKeySerializer(new StringRedisSerializer());
		  //设置值序列化属性
		  template.setValueSerializer(new RedisObjectSerializable());
		  return template;
	}
	
}
