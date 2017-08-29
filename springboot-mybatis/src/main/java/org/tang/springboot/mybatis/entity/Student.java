package org.tang.springboot.mybatis.entity;

import java.io.Serializable;
/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   学生的实体对象类
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
