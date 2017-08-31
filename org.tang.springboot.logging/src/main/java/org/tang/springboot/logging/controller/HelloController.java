package org.tang.springboot.logging.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐兴
 * @date   2017年8月31日
 * @desc   web控制器
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return "hello Springboot,"+name+" ! ";
	}
	
}
