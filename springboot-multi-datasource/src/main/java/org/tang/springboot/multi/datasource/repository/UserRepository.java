package org.tang.springboot.multi.datasource.repository;

import java.io.Serializable;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author 唐兴
 * @date   2017年8月15日
 * @desc   用户的dao接口
 */
@Repository("userRepositoryPrimary")
@Primary
public interface UserRepository extends JpaRepository<User, Serializable>{

}
