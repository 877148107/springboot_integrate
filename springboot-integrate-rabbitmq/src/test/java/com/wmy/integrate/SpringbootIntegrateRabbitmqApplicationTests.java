package com.wmy.integrate;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootIntegrateRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 利用rabbitMQ自动配置添加的AmqpAdmin系统管理功能组件，创建交换器、队列等
     */
    @Test
    public void createExchange(){
        //创建交换器
        amqpAdmin.declareExchange(new DirectExchange("rabbitmq.direct"));
        //创建队列
        amqpAdmin.declareQueue(new Queue("rabbitmq.queue"));
        //将队列和交换器绑定
        // String destination, 目的地
        // DestinationType destinationType, 目的地类型
        // String exchange, 交换器
        // String routingKey, 路由键
        // @Nullable Map<String, Object> arguments 参数头信息
        amqpAdmin.declareBinding(new Binding("rabbitmq.queue",
                Binding.DestinationType.QUEUE,
                "rabbitmq.direct",
                "rabbitmq.hello",
                null));
        //相关的删除可以使用amqpAdmin.delete.....
    }

    /**
     * exchange.direct 点对点发送消息
     */
    @Test
    void contextLoads() {
        //第一个参数路由器exchange：exchange.direct
        //第二参数路由键routingKey：	hello.news
        //第三个参数发送的消息体
        Map<String,Object> map = new HashMap<>();
        map.put("msg","xchange.direct 点对点发送消息");
        map.put("data", Arrays.asList("helloworld","张三",100,true));
        rabbitTemplate.convertAndSend("exchange.direct","hello.news",map);
    }

    /**
     * 获取消息
     */
    @Test
    void getRabbitMq(){
        Object o = rabbitTemplate.receiveAndConvert("hello.news");
        System.out.println("数据类型："+o.getClass());
        System.out.println("数据："+o);
    }

    /**
     * 广播模式exchange.fanout
     */
    @Test
    void sendMsg(){
        //第一个参数路由器exchange：exchange.direct
        //第二参数路由键routingKey：广播路由键为空
        //第三个参数发送的消息体
        Map<String,Object> map = new HashMap<>();
        map.put("msg","exchange.fanout广播发送消息");
        map.put("data", Arrays.asList("测试监听消息","王五",100,true));
        rabbitTemplate.convertAndSend("exchange.fanout","",map);
    }

}
