package com.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.service.KafkaService;

@RestController
public class kafkaController {

	@Autowired
	private KafkaService kafkaService;
	
	@GetMapping("/sendmessage")
	public void sendMessage(@RequestBody String message) {
		kafkaService.sendMessage(message);
	}
	
}
