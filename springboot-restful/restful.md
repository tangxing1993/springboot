## springboot-restful 
1. 创建简单的User实体类
2. 编写UserController控制类,使用restController,getMapping,postMapping,modelAttribute,PathVariable等注解
3. 使用MockMvc模拟测试
		
## 集成Mockmvc测试
1. 使用@Runwith（SpringRunner.class）注解
2. 使用@WebMvcTest(UserController.class)测试某个指定的控制器
3. 注入mockMvc模拟浏览器请求信息测试mvc层代码

## 集成统一异常配置

1. 添加thymeleaf模版支持（参考Springboot-template章节）
2. 在UserController控制器类中添加一个抛出异常的请求/user/hello
3. 添加一个全局异常配置通知类，用@ControllerAdvice注解,内部配置一个异常处理方法@ExceptionHandler注解该方法，方法内部返回错误视图，参考
   /springboot-restful/src/main/java/org/tang/springboot/restful/config/GloabelExceptionHandler.java
4. 在templates目录下创建error.html模版
5. 访问localhost:8080/user/hello即可看到错误通知	
6. 处理返回json的异常请求
7. 在userController下添加/user/json异常请求
8. 创建错误信息处理类ErrorInfo<T>
9. 在异常配置类中添加自定义的异常拦截处理，用于返回异常json串，在@ExceptionHandler下添加@reponseBody注解







