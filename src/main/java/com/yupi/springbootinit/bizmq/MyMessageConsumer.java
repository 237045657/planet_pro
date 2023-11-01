package com.yupi.springbootinit.bizmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyMessageConsumer {
    /**
     * 接收消息的方法
     * @param message 接收到的消息内容，是一个字符串类型
     * @param channel 消息所在的通道，可以通过该通道与 RabbitMQ进行交互，例如手动确认消息、拒绝消息等
     * @param deliveryTag 消息的投递标签，用于唯一标识一条消息
     */
    // 使用@sneakyThrows注解简化异常处理
    @SneakyThrows
    // 使用@RabbitListener注解指定要监听的队列名称为“code_queue"，并设置消息的确认机制为手动确认
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    // @Headerll(AmqpHeaders.DELIVERY_TAG) long deliveryTag是一个方法参数注解,用于从消息头中获取投递标签deliveryTag
    // 在RabbitMQ中,每条消息都会被分配一个唯一的投递标签，用于标识该消息在通道中的投递状态和顺序。
    // 通过使用@Headerll(AmqpHeaders.DELIVERY_TAG注解
    // 可以从消息头中提取该投递标签，并将其赋值给long deliveryTag)
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("receive Message = {}", message);
        channel.basicAck(deliveryTag, false);
    }
}
