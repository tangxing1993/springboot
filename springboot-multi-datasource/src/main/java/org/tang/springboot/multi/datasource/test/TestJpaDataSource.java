package org.tang.springboot.multi.datasource.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.multi.datasource.repository.UserRepository;

/**
 * @author 唐兴
 * @date   2017年8月15日
 * @desc   测试JPA多数据源 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpaDataSource {

	@Autowired
	@Qualifier("userRepositoryPrimary")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userRepositorySencondary")
	private org.tang.springboot.multi.datasource.secondary.repository.UserRepository repository;
	
	@Test
	public void testJpaPrimary() {
		assertEquals(1L, userRepository.count());	
		assertEquals(3L, repository.count());
	}


}
