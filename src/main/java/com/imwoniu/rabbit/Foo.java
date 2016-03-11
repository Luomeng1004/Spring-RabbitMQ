package com.imwoniu.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Work on 2016/3/11.
 */
public class Foo {

    public void listen(String foo) {
        System.out.println("Received Message:" + foo);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-rabbitmq.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

        template.convertAndSend("Hello, World!");
        Thread.sleep(1000);

    }

}
