package com.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jmsConsumer.xml");
    }
}
