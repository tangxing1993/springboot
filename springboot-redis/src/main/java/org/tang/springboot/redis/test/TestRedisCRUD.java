package org.tang.springboot.redis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   测试redis的crud操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisCRUD {

	@Autowired  
	private StringRedisTemplate template;  //注入redis核心访问对象
	
	@Test
	public void testAdd() {
		template.opsForValue().set("aaa", "111");
		assertEquals("111",template.opsForValue().get("aaa") );
	}
	
}
