package org.tang.springboot.multi.datasource.config;
/**
 * @author 唐兴
 * @date   2017年8月16日
 * @desc   次数据源JPA配置
 */

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  //开启式务管理器
@EnableJpaRepositories(
		entityManagerFactoryRef="entityManagerFactorySecondary",
		transactionManagerRef="transactionManagerSencondary",
		basePackages= {"org.tang.springboot.multi.datasource.secondary.repository"} //次repository的位置
		)
public class SecondaryConfig {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource dataSource;
	
	@Autowired
	private JpaProperties jpaProperties;
	
	/**
	 * 从数据源或hibernate的属性
	 * @param dataSource
	 * @return
	 */
	private Map<String,String> getVendorProperties(DataSource dataSource){
		return jpaProperties.getHibernateProperties(dataSource);
	}
	
	/**
	 * 创建实体管理器工厂对象
	 * @param builder
	 * @return
	 */
	@Bean("entityManagerFactorySecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource)
				.properties(this.getVendorProperties(dataSource))
				.packages("org.tang.springboot.multi.datasource.secondary.repository")
				.persistenceUnit("persistenceUnitSecondary")
				.build();
	}
    
	/**
	 * 获取实体管理器
	 * @param builder
	 * @return
	 */
	@Bean("entityManagerSencondary")
	public EntityManager entityManagerSencondary(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySecondary(builder).getObject().createEntityManager();
	}
	/**
	 * 事务处理器
	 * @param builder
	 * @return
	 */
	@Bean("transactionManagerSencondary")
	public PlatformTransactionManager transactionManagerSencondary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
	}
	
}
