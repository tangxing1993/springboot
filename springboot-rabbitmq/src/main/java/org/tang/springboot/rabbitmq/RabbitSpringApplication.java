package org.tang.springboot.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   
 */
@SpringBootApplication
@EnableScheduling   //开启定时任务扫描
public class RabbitSpringApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitSpringApplication.class, args);
	}
}
