package org.tang.springboot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   创建消息消费者
 */
@Component
@RabbitListener(queues="hello")    //使用监听注解，监听Rabbit队列内容
public class Receiver {

	private static final Logger logger  = LoggerFactory.getLogger(Receiver.class);
	
	@RabbitHandler   //rabbit消息处理器
	public void process(String hello) {
		logger.debug("Receive>>hello>>{}",hello);
	}
	
}
