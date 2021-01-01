package com.xywei.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅
 * 根据自己订阅的来接收消息
 * @author future
 * @Datetime 2021年1月1日 下午10:36:32<br/>
 * @Description
 */
@Component
public class FanoutConsumer {

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "fanout-info", type = "fanout")) })
	public void receiveInfo(String message) throws Exception {
		Thread.sleep(3000);
		System.out.println("consumer info 收到消息： " + message);
	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(name = "fanout-debug", type = "fanout")) })
	public void recevieDebug(String message) throws Exception {
		Thread.sleep(5000);
		System.out.println("consumer debug 收到消息" + message);
	}

}
