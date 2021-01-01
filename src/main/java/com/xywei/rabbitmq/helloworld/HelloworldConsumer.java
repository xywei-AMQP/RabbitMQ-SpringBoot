package com.xywei.rabbitmq.helloworld;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 声明接收的队列名字叫：springboot-helloworld，也就是默认路由key
 * 
 * @author future
 * @Datetime 2021年1月1日 下午7:33:13<br/>
 * @Description
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("springboot-helloworld"))
public class HelloworldConsumer {

	@RabbitListener(queuesToDeclare = @Queue("springboot-helloworld"))
	public void receive(String message) throws Exception {
		Thread.sleep(2000);
		System.out.println("HelloworldService接收消息： " + message);

	}
}
