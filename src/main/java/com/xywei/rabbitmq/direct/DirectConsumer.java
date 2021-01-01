package com.xywei.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumer {

	/**
	 * 接收info / debug / error消息
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午11:09:24<br/>
	 * @param message
	 * @throws Exception
	 */
	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "routing-name-direct", type = "direct"), key = {
					"info", "debug", "error" }) })
	public void receiveInfoDebugError(String message) throws Exception {
		Thread.sleep(5000);
		System.out.println("consumer InfoDebugError收到消息: " + message);
	}

	/**
	 * 只接收error消息
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午11:10:16<br/>
	 * @param message
	 * @throws Exception
	 */
	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "routing-name-direct", type = "direct"), key = {
					"error" }) })
	public void recevieError(String message) throws Exception {
		Thread.sleep(5000);
		System.out.println("consumer error收到消息：" + message);
	}
}
