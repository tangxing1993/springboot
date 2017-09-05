package org.tang.springboot.rabbitmq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.rabbitmq.Sender;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   测试amqp服务
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAmqp {

	@Autowired
	private Sender sender;

	@Test
	public void testSender() {
		sender.send();
	}
	
}
