# springboot使用AOP切面日志
1. 导入依赖关系

```
  <!-- 集成AOP功能，使用AOP切入日志操作 -->
  <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-aop</artifactId>
  </dependency>
```

2. 使用logbak-spring.xml配置日志的输出
3. 在application.yml中开启AOP配置
4. 创建无侵入的日志记录方法,创建切入面webLogAspect使用Aspect定义切入面
5. @PointCut定义切入点
6. @before在切入点之前执行
7. 使用@After在切入点结尾处切入内容
8. 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
9. 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
10. 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
11. 使用ThreadLocal处理定义基本变量同步问题
12. @order定义多个切面处理顺序的问题  值越小，优先级越高