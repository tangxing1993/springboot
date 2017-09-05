package org.tang.springboot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   ActuatorSpring程序的启动程序
 */
@SpringBootApplication
public class ActuatorSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ActuatorSpringApplication.class, args);
	}

}
