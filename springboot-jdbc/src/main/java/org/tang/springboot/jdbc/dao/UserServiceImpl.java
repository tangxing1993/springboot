package org.tang.springboot.jdbc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户接口的实现类
 * @author 唐兴
 * @date   2017年8月14日
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	//注入jdbc模版
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createUser(String name, Integer age) {
		logger.debug("开始写用户数据到数据库！");
		jdbcTemplate.update("insert into t_user(name,age)values(?,?)", name,age);
		logger.debug("用户数据写入完毕！");
	}

	@Override
	public void deleteUserByName(String name) {
		logger.debug("通过用户名删除数据库中用户,用户:{}",name);
		jdbcTemplate.update("delete from t_user where name=?",name);
		logger.debug("删除用户{}成功",name);
	}

	@Override
	public Integer getAllUsers() {
		logger.debug("获取数据库中的用户总数！");
		return jdbcTemplate.queryForObject("select count(id) from t_user", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		logger.debug("删除数据库中的所有用户!");
		jdbcTemplate.update("delete from t_user");
	}

}
