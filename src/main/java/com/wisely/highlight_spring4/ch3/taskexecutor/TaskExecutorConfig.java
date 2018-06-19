package com.wisely.highlight_spring4.ch3.taskexecutor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch3.taskexecutor")
@EnableAsync //开启对异步任务的支持
public class TaskExecutorConfig implements AsyncConfigurer{//2

	@Override
	public Executor getAsyncExecutor() {//2-这个就是线程池啦
		 ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
	        taskExecutor.setCorePoolSize(5);
	        taskExecutor.setMaxPoolSize(10);
	        taskExecutor.setQueueCapacity(25);
	        taskExecutor.initialize();
	        return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
