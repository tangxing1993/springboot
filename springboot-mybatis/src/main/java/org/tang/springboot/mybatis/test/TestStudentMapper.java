package org.tang.springboot.mybatis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.mybatis.mapper.StudentMapper;

/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   测试StudentMapper接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudentMapper {

	@Autowired
	private StudentMapper mapper;
	
	@Test
	public void testSelectStudentById() {
		assertEquals("zhangsan", mapper.getStudentById(1).getName());
	}
	
}
