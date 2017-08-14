# 使用jdbcTemplate访问数据库

1. 添加maven坐标依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

2. 创建数据库和配置数据库连接,数据库脚本jdbc.sql,数据库连接在application.yml文件内

3. 创建用户服务接口(org.tang.springboot.jdbc.dao.UserService)

4. 实现用户服务接口，注入jdbcTemplate操作数据库(org.tang.springboot.jdbc.dao.UserServiceImpl)

5. 使用测试方法测试 (org.tang.springboot.test.TestUserServiceImpl)