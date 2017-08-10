package org.tang.springboot.restful.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tang.springboot.restful.Exception.MyException;
import org.tang.springboot.restful.entity.User;
/**
 * 
 * @desc 用户的控制类 
 * @date 2017年8月8日
 * @author tx
 */
@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * 创建线程安全的用户表
	 */
	static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());
	
	private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
	/**
	 * 获取用户列表属性
	 * @return
	 */
	@GetMapping("/")
	public List<User> getUserList(){
		logger.debug(" Get users ! ");
		return new ArrayList<>(users.values());
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@PostMapping("/")
	public String postUser(@ModelAttribute User user){
		users.put(user.getId(), user);
		return "success";
	}
	/**
	 * 获取指定id的用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id){
		return users.get(id);
	}
	/**
	 * 修改用户信息
	 * @param id
	 * @param user
	 * @return
	 */
	@PutMapping("/{id}")
	public String putUser(@PathVariable("id") Long id,@ModelAttribute User user){
		User user2 = users.get(id);
		user2.setName(user.getName());
		user2.setAge(user.getAge());
		return "success";
	}
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id){
	    users.remove(id);
		return "success";
	}
	/**
	 * 测试配置全局异常
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/hello")
	public String Hello()throws Exception {
		throw new Exception("统一异常测试配置");
	}
	/**
	 * 自定义测试json异常
	 * @return
	 * @throws MyException
	 */
	@GetMapping("/json")
	public String HelloException()throws MyException{
		throw new MyException("自定义异常测试json异常");
	}
	
}
