package com.prayag.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prayag.domain.Person;

@RestController
@RequestMapping("/api")
public class TestController {
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

		@GetMapping("/test/{name}")
		public String testApi(@PathVariable("name")String name) {
			
			Person person = new Person(1, name);
			rabbitTemplate.convertAndSend("Mobile", person);
			//rabbitTemplate.convertAndSend("my-Direct-Exchange", "mob_k", person);
			//rabbitTemplate.convertAndSend("my-Fanout-Exchange", "", person);
			//rabbitTemplate.convertAndSend("my-Topic-Exchange", "tv.mobile.ac", person);
			
			return "success";
		}
		
}
