package com.example.kafka.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.Employee;

@RestController
@RequestMapping("jsonkafka")
public class JsonMessageControllerResource {
	
	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplateForJson;
	
	private static final String TOPIC= "MyTopicJson";

	@GetMapping("/publish/{name}")
	public String publishJsonMessage(@PathVariable("name") final String name) {
		kafkaTemplateForJson.send(TOPIC, new Employee(name, "IT", "KAFKA"));
		return "Info for name "+name+" is published";
	}
}
