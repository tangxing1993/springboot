package org.tang.springboot.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @desc Swagger的配置类 
 * @date 2017年8月9日
 * @author tx
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi(){
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				        .apiInfo(getApiInfo())
				        .select()
				        .apis(RequestHandlerSelectors.basePackage("org.tang.springboot.swagger2.controller"))
				        .paths(PathSelectors.any())
				        .build();
		return docket;
	}
	
	private ApiInfo getApiInfo(){
		return new ApiInfoBuilder()
				.title("springboot构建Swagger程序")
				.description("学习使用springboot构建Swagger程序")
				.contact("tangxingvip1993@gmail.com")
				.version("1.0")
				.build();
	}
	
}
