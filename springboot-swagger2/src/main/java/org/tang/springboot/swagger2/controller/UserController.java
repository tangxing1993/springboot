package org.tang.springboot.swagger2.controller;

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
import org.tang.springboot.swagger2.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @desc 用户的控制类 
 * @date 2017年8月9日
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
	@ApiOperation(value="获取用户列表",notes="")
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
	@ApiOperation(value="创建用户",notes="根据User对象创建用户")
	@ApiImplicitParam(name="User",value="用户详细实体User",required=true,dataType="User")
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
	@ApiOperation(value="获取用户",notes="根据用户id获取用户信息")
	@ApiImplicitParam(name="id",value="用户的id",required=true,dataType="Long")
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
	@ApiOperation(value="修改用户",notes="根据用户id和User信息修改用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="要修改用户的id",required=true,dataType="Long"),
		@ApiImplicitParam(name="User",value="要修改的用户信息",required=true,dataType="User")
	})
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
	@ApiOperation(value="删除用户",notes="根据用户信息删除用户")
	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="Long")
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id){
	    users.remove(id);
		return "success";
	}
	
}
