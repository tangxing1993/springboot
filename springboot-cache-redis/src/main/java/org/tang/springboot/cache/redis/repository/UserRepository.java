package org.tang.springboot.cache.redis.repository;

import java.io.Serializable;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tang.springboot.cache.redis.entity.User;
/**
 * @author 唐兴
 * @date   2017年8月29日
 * @desc   用户的操作
 */
@CacheConfig(cacheNames="users")
public interface UserRepository extends JpaRepository<User, Serializable> {

	/**
	 * 根据用户名称查询用户信息
	 * @param name
	 * @return
	 */
	@Query("from User u where u.name=:name")
	@Cacheable(key="#p0")
	User findUserByName(@Param("name") String name);
	
	/**
	 * 更新用户信息
	 */
	@CachePut(key="#p0.name")  //强制更新缓存中的对象信息
	User save(User user);
}
