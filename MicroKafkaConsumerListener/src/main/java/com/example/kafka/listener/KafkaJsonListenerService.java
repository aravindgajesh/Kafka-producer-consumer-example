package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.mode.Employee;

@Service
public class KafkaJsonListenerService {

	@KafkaListener(topics = "MyTopicJson", groupId = "json_group", containerFactory = "concurrentKafkaListenerContainerFactoryJson")
	public void consumeMessage(Employee employee) {
		System.out.println("My json from publisher is " + employee);
	}
}
