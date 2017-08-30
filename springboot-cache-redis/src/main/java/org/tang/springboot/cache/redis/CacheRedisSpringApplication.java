package org.tang.springboot.cache.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * @author 唐兴
 * @date   2017年8月29日
 * @desc   项目的启动程序
 */
@SpringBootApplication
@EnableCaching //开启缓存配置
public class CacheRedisSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CacheRedisSpringApplication.class, args);
	}
	
}
