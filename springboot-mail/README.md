# springboot集成邮件功能
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-mail</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

1. 在全局配置文件中配置邮件的信息
2. 编写测试文件，注入javaMailSender对象（该对象封装了发送邮件的核心API）
3. 集成freemarker模版邮件
4. 注入Configuration对象（freemarker的核心API）

