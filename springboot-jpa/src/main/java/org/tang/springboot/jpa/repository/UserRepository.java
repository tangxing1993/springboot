package org.tang.springboot.jpa.repository;

import java.io.Serializable;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tang.springboot.jpa.entity.User;

/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc 用户数据层接口
 */
@CacheConfig(cacheNames="users")   //缓存配置注解
public interface UserRepository extends JpaRepository<User, Serializable> {

	/**
	 * 通过用户名查询用户
	 * @param name
	 * @return
	 */
	@Query("from User u where u.name=:name")
	@Cacheable   //开启缓存
	User findUserByName(@Param("name") String name);
	
	
}
