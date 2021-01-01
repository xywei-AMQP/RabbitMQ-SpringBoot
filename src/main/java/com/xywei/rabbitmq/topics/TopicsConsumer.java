package com.xywei.rabbitmq.topics;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * user能接收全国的消息，beijing.user能接收北京/全国的消息
 * 
 * @author future
 * @Datetime 2021年1月1日 下午11:43:41<br/>
 * @Description
 */
@Component
public class TopicsConsumer {

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "routing-name-topics", type = "topic"), key = {
					"user.message" }) })
	public void receiveUser(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("全国用户到的消息：" + message);

	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "routing-name-topics", type = "topic"), key = {
					"#.user.message" }) })
	public void receiveBeijingUser(String message) throws Exception {
		Thread.sleep(3000);
		System.out.println("北京用户到的消息：" + message);

	}
}
