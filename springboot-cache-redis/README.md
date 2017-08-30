# 使用redis做集中式缓存
## 配置依赖关系

```
<!-- 添加springjpa支持 -->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- 添加缓存支持  -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!-- 添加mysql驱动 -->
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
</dependency>	
```

## JPA和Cache的常规配置
## 全局配置文件application.yml添加redis服务配置
## 在更新时使用CachePut注解，级联更新redis的缓存信息，确保信息一致