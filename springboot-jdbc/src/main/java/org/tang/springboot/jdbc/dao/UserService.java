package org.tang.springboot.jdbc.dao;
/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc 用户的数据层接口
 */
public interface UserService {

	/**
	 * 添加一个用户
	 * @param name 用户名
	 * @param age  年龄
	 */
	void createUser(String name,Integer age);
    /**
     * 根据用户名删除用户
     * @param name
     */
	void deleteUserByName(String name);
	/**
	 * 获取用户总量
	 * @return
	 */
	Integer getAllUsers();
	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();
	
}
