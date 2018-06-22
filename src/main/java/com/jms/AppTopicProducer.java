package com.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppTopicProducer {
    public static final String  url = "tcp://192.168.1.16:61616";
    public static final String topicName = "topic-test";

    public static void main(String[] args) {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Session session = null;
        Connection connection = null;
        //2.创建连接
        try {
            connection = connectionFactory.createConnection();
            //3.启动连接（这个很重要，不要忘了）
            connection.start();
            //4.创建会话
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //5.创建目标地址
            Destination destination = session.createTopic(topicName);
            //6.创建生产者
            MessageProducer producer = session.createProducer(destination);
            //7.创建并发送消息
            for (int i = 0; i < 50; i++) {
                TextMessage textMessage = session.createTextMessage("小花今年" + i+"岁了！");
                producer.send(textMessage);
                System.out.println("发送消息成功："+textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
