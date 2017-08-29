package org.tang.springboot.mybatis.Dao;
/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   实现类操作数据层
 */

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.tang.springboot.mybatis.entity.User;
@Component 
public class UserDao {

	private final SqlSession sqlSession;
	/**
	 * 构造方法注入sqlSession对象
	 * @param sqlSession
	 */
	public UserDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/**
	 * 根据用户id获取对象信息
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) {
		return this.sqlSession.selectOne("getUserById", id);
	}
	
}
