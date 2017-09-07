package org.tang.springboot.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   springboot集成邮件的启动程序
 */
@SpringBootApplication
public class MailSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MailSpringApplication.class, args);
	}
	
}
