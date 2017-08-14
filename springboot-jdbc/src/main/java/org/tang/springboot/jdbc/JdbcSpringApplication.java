package org.tang.springboot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc  springboot的启动程序
 */
@SpringBootApplication
public class JdbcSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JdbcSpringApplication.class, args);
	}
	
}
