package org.tang.springboot.config.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.config.properties.ConfigProperties;

/**
 * 单元测试属性是否加载
 * @desc 
 * @date 2017年8月9日
 * @author tx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConfigProperties {

	@Autowired
	private ConfigProperties properties;
	
	@Test
	public void testProperties(){
		assertEquals("tang", properties.getName());
		assertEquals("springbootlearn", properties.getTitle());
		System.out.println("DESC>>"+properties.getDesc());
		System.out.println("VALUE>>"+properties.getValue());
		System.out.println("INT>>"+properties.getInt1());
		System.out.println("LONG>>"+properties.getLong1());
		System.out.println("INT10>>"+properties.getInt10());
		System.out.println("INT20>>"+properties.getInt20());
	}
	
}
