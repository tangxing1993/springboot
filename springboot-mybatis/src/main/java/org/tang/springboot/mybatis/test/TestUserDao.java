package org.tang.springboot.mybatis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.mybatis.Dao.UserDao;

/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   测试userDao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserDao.class)
public class TestUserDao {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetUserBtId() {
		assertEquals("tangxing", this.userDao.getUserById(1).getUsername());
	}
	
}
