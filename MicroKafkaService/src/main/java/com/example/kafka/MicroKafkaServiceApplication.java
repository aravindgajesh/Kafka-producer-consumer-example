package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Autoconfiguration + configuration + componentscan
@SpringBootApplication
public class MicroKafkaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroKafkaServiceApplication.class, args);
	}

}
