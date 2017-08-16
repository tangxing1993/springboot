# springboot多数据源的配置

## JDBC多数据源（见main）

### 添加springboot-jdbc支持

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

### 创建多数据源的配置 （org.tang.springboot.multi.datasource.config.DataSourceConfig）

	- @Configuration 注解加载配置类
	- @Primary  注解多接口的实现
	- @ConfigurationProperties 加载配置文件属性,该注解需要导入spring-boot-configuration-processor包

### 测试多数据源的(org.tang.springboot.multi.datasource.test.TestJdbcTemplate)

## JPA多数据源的配置（见main下的org.tang.springboot.multi.datasource.config）

    - PrimaryConfig     主Jpa配置
    - SencondaryConfig  次jpa配置   
 	 
### 添加jpa的maven依赖

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

