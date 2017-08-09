package org.tang.springboot.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 自定义的属性文件，接受配置文件中的参数
 * @desc 
 * @date 2017年8月9日
 * @author tx
 */
@Component
public class ConfigProperties {

	@Value("${org.tang.springboot.config.name}")
	private String name;
	@Value("${org.tang.springboot.config.title}")
	private String title;
	@Value("${org.tang.springboot.config.desc}")
	private String desc;
	@Value("${org.tang.springboot.config.value}")
	private String value;
    @Value("${org.tang.springboot.config.int}")
	private int int1;
    @Value("${org.tang.springboot.config.long}")
    private long long1;
	@Value("${org.tang.springboot.config.int10}")
    private int int10;
	@Value("${org.tang.springboot.config.int20}")
	private int int20;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public long getLong1() {
		return long1;
	}

	public void setLong1(long long1) {
		this.long1 = long1;
	}

	public int getInt10() {
		return int10;
	}

	public void setInt10(int int10) {
		this.int10 = int10;
	}

	public int getInt20() {
		return int20;
	}

	public void setInt20(int int20) {
		this.int20 = int20;
	}
}
