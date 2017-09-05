package org.tang.springboot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 唐兴
 * @date   2017年8月31日
 * @desc   项目的启动程序
 */
@SpringBootApplication
public class LoggingSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoggingSpringApplication.class);
	
	public static void main(String[] args) throws Exception {
		logger.debug("------------>>>>>{}","日志项目开始启动");
		SpringApplication.run(LoggingSpringApplication.class, args);
		logger.debug("------------>>>>>{}","日志项目成功启动");
	}

}
