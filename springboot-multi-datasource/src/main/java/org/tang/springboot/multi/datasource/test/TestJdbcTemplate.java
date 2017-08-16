package org.tang.springboot.multi.datasource.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 唐兴
 * @date   2017年8月15日
 * @desc   测试jdbc多数据源
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbcTemplate {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate template1;
	
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate template2;
	
	@Test
	public void testTemplate1() {
		assertEquals(new Integer(1), template1.queryForObject("select count(1) from t_user", Integer.class));
	}
	
	@Test
	public void testTemplate2() {
		assertEquals(new Integer(3), template2.queryForObject("select count(1) from t_user",Integer.class) );
	}
	
	
}
