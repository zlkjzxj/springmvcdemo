package com.springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
    //使用资源是因为可能配置多个目的地，用名字来区分
    @Resource(name = "queueDestination")
    Destination destination;

    /**
     * 向指定队列发送消息
     */
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("发送了：" + textMessage.getText());
                return textMessage;
            }
        });
    }
}
