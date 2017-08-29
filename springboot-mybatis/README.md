# springboot整合mybatis

## 导入依赖关系

```
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>1.3.0</version>
		</dependency>
        <dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	    </dependency>
		<!-- test dependencies -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter-test</artifactId>
			<version>1.3.0</version>
			<scope>test</scope>
		</dependency>
```
    -- 配置application.yml （spring.mybatis的配置）
    -- 创建mybatis的配置文件
    -- mybatis两种实现方式（接口映射<studentMapper>和类映射<userDao>） 
    -- 测试数据层接口
