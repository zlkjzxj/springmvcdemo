package com.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppConsumer {
    public static String url = "tcp://192.168.1.181:61616";
    public static String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        /**
         *
         * 假如有两个消费者的话他们会平分消息，一个接收jish奇数，一个接收偶数
         *
         */
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //2.创建连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接（这个很重要，不要忘了）
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目标地址
        Destination destination = session.createQueue(queueName);
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
