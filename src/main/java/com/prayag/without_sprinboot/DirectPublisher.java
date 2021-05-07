package com.prayag.without_sprinboot;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "This is ac-prayag";
		
		channel.basicPublish("my-Direct-Exchange", "ac_k", null, message.getBytes());
		
		System.out.println("success");
		channel.close();
		connection.close();
	}

}
