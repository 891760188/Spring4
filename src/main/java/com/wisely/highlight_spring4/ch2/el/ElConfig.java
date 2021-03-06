package com.wisely.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 数据的注入方式
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:test.properties")//7-注入配置文件
public class ElConfig {
	
	@Value("I Love You!") //1-注入普通字符
    private String normal;

	@Value("#{systemProperties['os.name']}") //2-注入操作系统属性
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //3-注入表达式结果
    private double randomNumber;

	@Value("#{demoService.another}") //4-注入其它bean的属性
	private String fromAnother;

	@Value("classpath:test.txt") //5-注入文件资源
	private Resource testFile;

	@Value("http://www.baidu.com") //6-注入网址资源
	private Resource testUrl;

	@Value("${book.name}") //7-注入配置文件-此处用的是美元符号
	private String bookName;

	@Autowired
	private Environment environment; //7-可以从此处取出properties的值

	@Bean //7 使用@value注入，需要配置这个备案
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	


	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));

			environment.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
