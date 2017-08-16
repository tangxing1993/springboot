package org.tang.springboot.multi.datasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 唐兴
 * @date   2017年8月14日
 * @desc   多数据源的配置文件
 */
@Configuration
public class DataSourceConfig {

	
	/**
	 * 配置主数据源
	 * @return
	 */
	@Bean("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 配置次数据源
	 * @return
	 */
	@Bean("secondaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource SecondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 容器化主jdbcTenplate
	 * @param dataSource
	 * @return
	 */
	@Bean("primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
    /**
     * 容器化次数据源
     * @param dataSource
     * @return
     */
	@Bean("secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
