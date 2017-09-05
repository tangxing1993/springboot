package org.tang.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   异步调用的启动程序
 */
@SpringBootApplication
@EnableAsync   //开启异步注解扫描
public class AsyncSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AsyncSpringApplication.class, args);
	}

	
}
