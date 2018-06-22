package com.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("jmsProducer.xml");
        ProducerService bean = context.getBean(ProducerService.class);
        for (int i = 0; i < 50; i++) {
            bean.sendMessage("fuck"+i+"次");
        }

    }
}
