package com.pp.spring.kafka.api;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String,Object> template;

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		template.send("kafka-test", "Hi, "+name);
		return "Data Published";
	}

	@GetMapping("/publishJson")
	public String publishMessage(){
		User user = new User(123,"harshal",new String[]{"sector 7","sanpada"});
		template.send("kafka-test", user);
		return "Json Data Published";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
