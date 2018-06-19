package com.wisely.highlight_spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class AsyncTaskService {
	
	@Async //1-说明这是个异步方法，如果该注解在类上，此类下的所有的方法都是异步方法  用线程池
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务: "+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1: "+(i+1));
    }

}
