# 基于NOSQL的Redis数据库

## 添加依赖

```
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

## 简单的测试程序

1. application.yml配置redis属性
2. TestRedisCRUR.java测试简单的CRUD操作,使用StringRedisTemplate核心API

## 存贮对象类型的数据
1. 创建存储的对象实体并实现序列化接口
2. 创建对象的序列类
3. 创建redis的配置类，获取redis对象类型的模版对象
