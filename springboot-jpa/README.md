# 使用jpa来简化数据层

## 添加依赖文件

```
<dependencies>
<!-- 添加springjpa支持 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- 添加mysql驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
</dependencies>
```
1. 创建数据库脚本和配置数据库连接
2. 创建用户实体类，使用@entity和@table使该类变为持久类  @id声明字段为主键 @generateValue注解主键的生成方式
3. 创建用户服务接口继承jpaRepository包含公用的方法 
4. 测试服务接口（org.tang.springboot.jpa.test.TestUserRepository）
