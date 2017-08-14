# 使用Swagger2来构建强大的Restful项目

1. 导入Swagger2的依赖坐标

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.2.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.2.2</version>
</dependency>
```

2. 创建Swagger的配置类(org.tang.springboot.swagger2.config.SwaggerConfig)
	
	- 在配置类中创建Swagger的docket对象,使用Docket构建器
	- ApiInfo 配置Swagger的基本信息（title,description,contact,version）
	- select() 启动一个API生成器
	- ApiSelectorBuilder用来控制那些接口暴露 （指定固定包下的Controller）
	- @ApiOperarion(value="功能",notes="描述")
    - @ApiImpicitParam(name="参数名称",value="参数说明",require=true(参数是否必须),dataType="参数类型")
    
3. 访问localhost:8080/swagger-ui.html可以看到接口描述    