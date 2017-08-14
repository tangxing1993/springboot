package org.tang.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @desc 欢迎控制器类 
 * @date 2017年8月10日
 * @author tx
 */
@Controller
public class HelloController {
    /**
     * 跳转索引页面
     * @return
     */
	@GetMapping("/")
	public String index(){
		return "index";
	}
	/**
	 * 跳转欢迎页面
	 * @return
	 */
	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	/**
	 * 跳转用户登录页面
	 * @return
	 */
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
}
