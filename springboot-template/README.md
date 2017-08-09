# ** springboot的模版说明文件 ** #

## springboot支持的模版类型

1. Thymeleaf
2. FreeMarker
3. Velocity
4. Groovy
5. Mustache

## 静态资源的配置

- springboot默认支持静态资源放在 /MATA-INF/resources、/resources、/static、/public目录下
- 查找优先顺序 /MATA-INF/resources>/resources>/static>/publics

## Thymeleaf模版

>>Thymeleaf是一个XML/XHTML/HTML5模板引擎，可用于Web与非Web环境中的应用开发。它是一个开源的Java库，基于Apache License 2.0许可，由Daniel Fernández创建，该作者还是Java加密库Jasypt的作者。

>>Thymeleaf提供了一个用于整合Spring MVC的可选模块，在应用开发中，你可以使用Thymeleaf来完全代替JSP或其他模板引擎，如Velocity、FreeMarker等。Thymeleaf的主要目标在于提供一种可被浏览器正确显示的、格式良好的模板创建方式，因此也可以用作静态建模。你可以使用它创建经过验证的XML与HTML模板。相对于编写逻辑或代码，开发者只需将标签属性添加到模板中即可。接下来，这些标签属性就会在DOM（文档对象模型）上执行预先制定好的逻辑。

- 引入thymeleaf的坐标文件

` <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
`
- localhost:8088/template/  测试Thymeleaf模版文件
- 如果访问模版报错 org.xml.sax.SAXException: Scanner State 24 not Recognized,去掉模版头部的<!DOCTYPE>
- Thymeleaf的springboot配置见application-dev.yml


