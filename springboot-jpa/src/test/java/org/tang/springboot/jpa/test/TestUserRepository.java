package org.tang.springboot.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.jpa.JpaSpringApplication;
import org.tang.springboot.jpa.entity.User;
import org.tang.springboot.jpa.repository.UserRepository;

/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc   测试用户的业务层接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaSpringApplication.class)
public class TestUserRepository {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void save() {
		User user = new User();
		user.setName("唐兴");
		user.setAge(24);
		repository.save(user);
	}
	
}
