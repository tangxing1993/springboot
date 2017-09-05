# 使用springboot整合ampq和使用定时任务schedule

```
 <dependencies>
 	<!-- 添加amqp依赖 -->
 	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-amqp</artifactId>
	</dependency>
 </dependencies>
```

#  Message Broker与AMQP简介
## Message Broker是一种消息验证、传输、路由的架构模式，其设计目标主要应用于下面这些场景：
- 消息路由到一个或多个目的地
- 消息转化为其他的表现方式
- 执行消息的聚集、消息的分解，并将结果发送到他们的目的地，然后重新组合相应返回给消息用户
- 调用Web服务来检索数据
- 响应事件或错误
- 使用发布-订阅模式来提供内容或基于主题的消息路由

## AMQP是Advanced Message Queuing Protocol的简称，它是一个面向消息中间件的开放式标准应用层协议。AMQP定义了这些特性：
- 消息方向
- 消息队列
- 消息路由（包括：点到点和发布-订阅模式）
- 可靠性
- 安全性

## RabbitMq安装
1. 安装Erland，通过官方下载页面http://www.erlang.org/downloads获取exe安装包，直接打开并完成安装。（rabbit依赖的环境）
2. 安装RabbitMQ，通过官方下载页面https://www.rabbitmq.com/download.html获取exe安装包。
3. 下载完成后，直接运行安装程序。
4. RabbitMQ Server安装完成之后，会自动的注册为服务，并以默认配置启动起来。
5. 执行rabbitmq-plugins enable rabbitmq_management命令，开启Web管理插件，这样我们就可以通过浏览器来进行管理了。
6. 打开浏览器并访问：http://localhost:15672/，并使用默认用户guest登录，密码也为guest。
7. 我们在用户管理页面，新建用户，并增加访问控制(一定要加访问控制，不然会又sorket异常)

## 测试Spring集成RabbitMq
1. 创建生产者（Sender.java）,使用RabbitTemplate调用核心API
2. 创建消费者（receiver.java）,使用RabbitListern注解监听生产者的消息,使用RabbitHandler处理生产者产生的消息
3. 创建RabbitConfig的配置类，配置路由等选项
4. 在application.yml中配置RabbitMq的连接选项

## 集成定时任务

1. 在启动程序上启用定时任务注解(@EnableSchedule)
2. 在要做的任务上面添加时刻表注解(@Schedule(各种触发器属性))

- fixedRate=5000        上一次开始执行时间点之后5秒再执行
- fixedDelay=5000       上一次执行完毕时间点之后5秒再执行
- initialDelay=5000     第一次延迟1秒后执行
- cron="*/5 * * * * *"  通过cron表达式定义规则




