# 使用springSecurity做权限控制

1. 配置SpringSecurity的maven依赖文件
`
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
`
2. 添加thymeleaf模版依赖

`
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
`
3. 编写Springboot的Security的配置类(参考org.tang.springboot.security.config.WebSecurityConfig)
	
	- 该类继承WebSecurityConfigurerAdapter,重写配置方法
	- 在配置方法中添加过滤方式（定义那些url需要保护）
	- 在内存中创建用户,密码,角色
	- 在类上方添加注解configuration和enableWebSecurity开启注解配置和启用Security注解
	
4. 在templates目录下添加模版文件
5. 在org.tang.springboot.security.controller下编写访问控制类
6. 访问localhost:8080/security/ 验证security


