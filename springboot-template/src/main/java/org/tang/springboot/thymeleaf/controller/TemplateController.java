package org.tang.springboot.thymeleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @desc 模版控制器，测试thymeleaf模版 
 * @date 2017年8月9日
 * @author tx
 */
@Controller
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class); 
	
	/**
	 * 测试Thymeleaf模版
	 * @param map
	 * @return
	 */
	@GetMapping("/")
	 public String index(ModelMap map){
		logger.debug(" requesting TemplateController index page! ");
		 map.addAttribute("host", "https://www.baidu.com");
		 return "index";
	 }
}
