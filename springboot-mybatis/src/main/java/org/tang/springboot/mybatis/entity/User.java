package org.tang.springboot.mybatis.entity;

import java.io.Serializable;
/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   用户的实体类
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
