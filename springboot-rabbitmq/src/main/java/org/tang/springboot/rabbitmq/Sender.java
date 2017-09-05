package org.tang.springboot.rabbitmq;
/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   发送者
 */

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);
	
	@Autowired   //注入操作模版
	private RabbitTemplate template;
	
	@Scheduled(fixedDelay=1000L)  //开启定时任务，延迟一秒发送   fixedRate=5000L
	public void send() {
		String context = "Hello Rabbit,"+new Date().toLocaleString();
		logger.debug("send>>context>>{}",context);
		this.template.convertAndSend("hello",context);
	}
	
	
}
