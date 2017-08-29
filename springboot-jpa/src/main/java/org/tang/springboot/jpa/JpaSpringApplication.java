package org.tang.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc  springboot的启动程序
 */
@SpringBootApplication
@EnableCaching  //开启缓存功能
public class JpaSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JpaSpringApplication.class, args);
	}

	
}
