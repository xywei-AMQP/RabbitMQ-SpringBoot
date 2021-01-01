# 问题
1. 如何配置实现路由、队列、消息的持久化  
  -- sprngboot默认消息实现了持久化  
2. **如何实现手动的消息确认和实现能者多劳？**

# 功能
1. 整合springboot、RabbitMQ
2. 实现rabbitmq五种工作模型：helloworld、work queues、publish/subscribe、direct、topics

# 总结 
1. rabbitmq其实大体分为四种：default、fanout、direct、topic
2. work queues模型中，默认是平均分配，如果其他consumer没有处理或者宕机了，也会由正常工作的**帮忙**处理，你正常工作，我就不处理，你处理不过来，我就帮忙。


# 环境
JDK8、springboot2.4.1

# 整合步骤
1. 建立springboot工程，勾选web、rabbit-amqp，springboot默认支持rabbitmq
2. 在application.yml配置rabbitmq

# API使用
1. RabbitmqTemplate
2. convertAndSend()
3. @RabbitListener