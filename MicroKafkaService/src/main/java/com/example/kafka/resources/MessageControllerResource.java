package com.example.kafka.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class MessageControllerResource {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC= "MyTopic";
	
	
	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") final String message) {
		
		kafkaTemplate.send(TOPIC, message);
		return "Published successfully "+ message;
	}
	
}
