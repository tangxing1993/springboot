package org.tang.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   项目启动程序
 */
@SpringBootApplication
public class RedisSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RedisSpringApplication.class, args);
	}
	
}
