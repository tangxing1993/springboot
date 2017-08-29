package org.tang.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tang.springboot.mybatis.entity.Student;

/**
 * @author 唐兴
 * @date   2017年8月28日
 * @desc   
 */
@Mapper
public interface StudentMapper {

	/**
	 * 根据id获取学生信息
	 * @param id
	 * @return
	 */
	Student getStudentById(Integer id);
	
}
