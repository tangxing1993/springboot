package org.tang.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @desc 创建Security的配置类
 * @date 2017年8月10日
 * @author tx
 */
@Configuration
@EnableWebSecurity  //该注解开启springSecurity功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override  //重写web安全配置方面的细节
	protected void configure(HttpSecurity http) throws Exception {
		http
		   .authorizeRequests()  //验证连接
		   		.antMatchers("/","/home").permitAll()  //放行 /和/home连接 
		   		.anyRequest().authenticated() //其余连接必须授权
		   		.and()    //连接其余的HttpSecurity配置
		   	.formLogin()        //放行登录连接
		   		.loginPage("/login")
		   		.permitAll()
		   		.and()
		   	.logout()     //放行登出连接
		   		.permitAll();
	}
	/**
	 * 在内存中创建一个用户
	 * @param auth
	 * @throws Exception
	 */
    @Autowired   
	public void configureGloabal(AuthenticationManagerBuilder auth)throws Exception{
		auth
			.inMemoryAuthentication()  
				.withUser("user").password("password").roles("USER");
	}
	
}
