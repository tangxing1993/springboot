package org.tang.springboot.redis.entity;

import java.io.Serializable;
/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   用户实体
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
