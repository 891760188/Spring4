package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration //声明这是一个配置类，这意味这有0个或多个@bean注解，此处没有使用包扫描，是因为所有的bean都在此类中定义了
public class JavaConfig {
	@Bean //使用bean注解当前的方法的返回值是一个bean，bean的名称是方法名
	public FunctionService functionService(){
		return new FunctionService();
	}
	@Bean //
	public UseFunctionService useFunctionService(){
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService()); //注入bean的时候直接调用上述方法
		return useFunctionService;
		
	}
//	@Bean 
//	public UseFunctionService useFunctionService(FunctionService functionService){//functionService作为参数写入，在spring容器中，只要容器中存在某个bean，就可以在另一个bean的声明方法中写入
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
}
