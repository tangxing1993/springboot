package org.tang.springboot.restful.entity;

import java.io.Serializable;
/**
 * 
 * @desc  用户实体类
 * @date 2017年8月8日
 * @author tx
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
