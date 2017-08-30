package org.tang.springboot.cache.redis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.cache.redis.entity.User;
import org.tang.springboot.cache.redis.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CacheManager CacheManager;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("zhangsan");
		user.setAge(10);
		repository.save(user);
	}
	
	@Test
	public void testFindUserByName() {
		assertEquals(new Integer(10), repository.findUserByName("zhangsan").getAge());
		assertEquals(new Integer(10), repository.findUserByName("zhangsan").getAge());
		User user = repository.findUserByName("zhangsan");
		user.setAge(24);
		assertEquals(new Integer(24),repository.save(user).getAge());
	}
	
}
