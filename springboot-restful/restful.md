## springboot-restful 
1. 创建简单的User实体类
2. 编写UserController控制类,使用restController,getMapping,postMapping,modelAttribute,PathVariable等注解
3. 使用MockMvc模拟测试
		
## 集成Mockmvc测试
1. 使用@Runwith（SpringRunner.class）注解
2. 使用@WebMvcTest(UserController.class)测试某个指定的控制器
3. 注入mockMvc模拟浏览器请求信息测试mvc层代码


