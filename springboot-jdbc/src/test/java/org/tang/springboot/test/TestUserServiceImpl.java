package org.tang.springboot.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.jdbc.JdbcSpringApplication;
import org.tang.springboot.jdbc.dao.UserService;
/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc  junit测试jdbcTemplate访问数据库
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=JdbcSpringApplication.class)
public class TestUserServiceImpl {
 
	//注入用户dao
	@Autowired
	private UserService service;
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		service.createUser("唐兴", 24);
		service.createUser("张三", 25);
		service.createUser("陈留", 23);
	}

	@Test
	public void testDeleteUserByName() {
		service.deleteUserByName("唐兴");
	}

	@Test
	public void testGetAllUsers() {
		Assert.assertEquals(new Integer(2), service.getAllUsers());
	}

	@Test
	public void testDeleteAllUsers() {
		service.deleteAllUsers();
	}

}
