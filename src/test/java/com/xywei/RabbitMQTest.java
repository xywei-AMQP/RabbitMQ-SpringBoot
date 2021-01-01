package com.xywei;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMQTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testConnection() {
		System.out.println(rabbitTemplate == null);
		if (rabbitTemplate != null) {
			boolean open = rabbitTemplate.getConnectionFactory().createConnection().isOpen();
			System.out.println(open);

		}
	}

	/**
	 * 测试Helloworld模型，使用默认路由
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午7:19:47<br/>
	 */
	@Test
	public void helloworldProvider() {
		for (int i = 1; i <= 10; i++) {
			rabbitTemplate.convertAndSend("springboot-helloworld",
					new Date() + " springboot整合rabbitmq，使用helloworld模型" + i);
		}
	}

	/**
	 * work queues模型
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午10:14:57<br/>
	 */
	@Test
	public void workQueuesProvider() {
		for (int i = 0; i < 100; i++) {
			rabbitTemplate.convertAndSend("work-queues", "使用work-queues模型" + i);
		}
	}

	/**
	 * fanout模型，也就是publish/subscribe，有routingkey，但是为""
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午10:15:24<br/>
	 */
	@Test
	public void fanoutInfoProvider() {
		for (int i = 1; i <= 10; i++) {
			rabbitTemplate.convertAndSend("fanout-info", "", i + "fanout模型 info");
		}

	}

	/**
	 * fanout模型，有routingkey，但是为""
	 * 
	 * @Description
	 * @Datetime 2021年1月1日 下午10:40:43<br/>
	 */
	@Test
	public void fanoutDebugProvider() {
		for (int i = 1; i <= 10; i++) {
			rabbitTemplate.convertAndSend("fanout-debug", "", i + "fanout模型debug");
		}

	}

}
