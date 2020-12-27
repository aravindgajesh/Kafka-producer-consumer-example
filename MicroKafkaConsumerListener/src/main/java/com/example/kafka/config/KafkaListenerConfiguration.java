package com.example.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.kafka.mode.Employee;


@EnableKafka
@Configuration
public class KafkaListenerConfiguration {

	@Bean
	public ConsumerFactory<String, String> consumerFactoryString() {

		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "string_group");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, String> myFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		myFactory.setConsumerFactory(consumerFactoryString());

		return myFactory;
	}
	
	@Bean
	public ConsumerFactory<String, Employee> consumerFactoryJson() {
		JsonDeserializer<Employee> deserializer = new JsonDeserializer<>(Employee.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);
	    
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "json_group");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Employee> concurrentKafkaListenerContainerFactoryJson() {

		ConcurrentKafkaListenerContainerFactory<String, Employee> myFactory = new ConcurrentKafkaListenerContainerFactory<String, Employee>();
		myFactory.setConsumerFactory(consumerFactoryJson());

		return myFactory;
	}

}
