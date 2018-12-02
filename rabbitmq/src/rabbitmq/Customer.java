package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Customer {
    private final static String QUEUE_NAME = "rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        // �������ӹ���
        ConnectionFactory factory = new ConnectionFactory();
        //����RabbitMQ��ַ
        factory.setHost("192.168.1.7");
        factory.setUsername("root");
        factory.setPassword("123456");
        factory.setPort(5672);
        //����һ���µ�����
        Connection connection = factory.newConnection();
        //����һ��ͨ��
        Channel channel = connection.createChannel();
        //����Ҫ��ע�Ķ���
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        System.out.println("Customer Waiting Received messages");
        //DefaultConsumer��ʵ����Consumer�ӿڣ�ͨ������һ��Ƶ����
        // ���߷�����������Ҫ�Ǹ�Ƶ������Ϣ�����Ƶ��������Ϣ���ͻ�ִ�лص�����handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //�Զ��ظ�����Ӧ�� -- RabbitMQ�е���Ϣȷ�ϻ���
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}