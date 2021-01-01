package com.xywei.rabbitmq.workqueues;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkQueuesConsumer {

	@RabbitListener(queuesToDeclare = @Queue("work-queues"))
	public void receive1(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("consumer1: " + message);
	}

	@RabbitListener(queuesToDeclare = @Queue("work-queues"))
	public void receive2(String message) throws Exception {
		Thread.sleep(3000);
		System.out.println("consumer2: " + message);

	}

}
