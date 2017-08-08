package org.tang.springboot.restful;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.ConnectException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.tang.springboot.restful.controller.UserController;

/**
 * @desc mvc模拟测试 
 * @date 2017年8月8日
 * @author tx
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class TestUserController {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testController() throws Exception{
		/*测试获取用户列表*/
		this.mvc.perform(get("/user/"))
		        .andExpect(status().isOk())
		        .andExpect(content().string(equalTo("[]")));
		/*添加用户信息*/
		this.mvc.perform(post("/user/").param("id","1").param("name", "tangxing").param("age", "24"))
									   .andExpect(status().isOk())
									   .andExpect(content().string("success"));
		/*获取用户信息*/
		this.mvc.perform(get("/user/1")).andExpect(status().isOk())
										.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"tangxing\",\"age\":\"24\"}")));
		/*修改用户信息*/
		this.mvc.perform(put("/user/1").param("name", "zhangsan"))
				.andExpect(status().isOk())
				.andExpect(content().string("success"));
		/*删除用户信息*/
		this.mvc.perform(delete("/user/1"))
				.andExpect(status().isOk())
				.andExpect(content().string("success"));
	}
	
}
