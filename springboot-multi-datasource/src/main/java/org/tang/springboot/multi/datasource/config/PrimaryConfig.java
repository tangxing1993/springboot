package org.tang.springboot.multi.datasource.config;

import java.util.Map;

import javax.persistence.EntityManager;
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

/**
 * @author 唐兴
 * @date   2017年8月15日
 * @desc   主数据源的JPA配置
 */
@Configuration
@EnableTransactionManagement  //开启事务管理器
@EnableJpaRepositories(
		entityManagerFactoryRef="entityManagerFactoryPrimary",   
		transactionManagerRef="transactionManagerPrimary",
		basePackages= {"org.tang.springboot.multi.datasource.repository"}
		)
public class PrimaryConfig {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource dataSource;   //注入主数据源
	
	@Autowired
	private JpaProperties jpaProperties;  //从数据源中获取hibernate的数据属性
	
	/**
	 * @param dataSource
	 * @return  获取数据源的属性
	 */
	private Map<String,String>  getVenderProperties(DataSource dataSource){
		return jpaProperties.getHibernateProperties(dataSource);
	}
	
	/**
	 * 获取本地容器实体管理器工厂类
	 * @param builder
	 * @return
	 */
	@Bean("entityManagerFactoryPrimary")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource)
			    .properties(getVenderProperties(dataSource))
				.packages("org.tang.springboot.multi.datasource.repository")
			    .persistenceUnit("primaryPersistenceUnit")
				.build();
	}
	/**
	 * 获取实体管理器
	 * @param builder
	 * @return
	 */
	@Bean("entityManagerPrimary")
    @Primary
	public EntityManager primaryEntityManager(EntityManagerFactoryBuilder builder) {
    	return entityManagerFactoryPrimary(builder)
    			.getObject()
    			.createEntityManager();
    }
	/**
	 * 获取主事务管理器
	 * @param builder
	 * @return
	 */
	@Bean("transactionManagerPrimary")
	@Primary
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}
	
	
}
