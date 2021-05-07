package com.prayag.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.prayag.domain.Person;

@Service
public class RabbitConsumer {
	
	@RabbitListener(queues = "Mobile")
	public void getMessage(Person person) {
		
		System.out.println(person.getName());
		
	}
}
