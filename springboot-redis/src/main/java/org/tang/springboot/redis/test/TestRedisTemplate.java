package org.tang.springboot.redis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.redis.entity.User;

/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   测试redis存储对象
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

	@Autowired
	private RedisTemplate<String,User> template;
	
	@Test
	public void test() {
		User user = new User();
		user.setName("张三");
		user.setAge(24);
		template.opsForValue().set("zs", user);
		assertEquals(new Integer(24), template.opsForValue().get("zs").getAge());
		
	}
	
	
}
