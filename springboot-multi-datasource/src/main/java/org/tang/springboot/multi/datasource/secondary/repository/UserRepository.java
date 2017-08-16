package org.tang.springboot.multi.datasource.secondary.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author 唐兴
 * @date   2017年8月16日
 * @desc   次jpa的userRepository接口
 */
@Repository("userRepositorySencondary")
public interface UserRepository extends JpaRepository<User, Serializable> {

}
