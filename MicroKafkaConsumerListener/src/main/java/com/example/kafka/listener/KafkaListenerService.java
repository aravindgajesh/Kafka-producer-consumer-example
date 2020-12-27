package com.example.kafka.listener;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaListenerService {

	@KafkaListener(topics = "MyTopic", groupId = "string_group")
	public void consumeMessage(String message) {
		System.out.println("My message from publisher is " + message);
	}
}
