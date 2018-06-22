package com.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppTopicConsumer {
    public static String url = "tcp://192.168.1.16:61616";
    public static String topicName = "topic-test";

    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //2.创建连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接（这个很重要，不要忘了）
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目标地址
        Destination destination = session.createTopic(topicName);
        //6.接收消息
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息成功："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
