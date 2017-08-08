package org.tang.springboot.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc springboot的启动程序
 * @date 2017年8月8日
 * @author tx
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class RestfulSpringApplication {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(RestfulSpringApplication.class, args);
	}
	@RequestMapping("/")
	@ResponseBody
	public String helloWorld(){
		return "Hello Springbooot!";
	}
}
