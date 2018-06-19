package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("接收到了容器发布的事件:"+ msg);
	}
}
