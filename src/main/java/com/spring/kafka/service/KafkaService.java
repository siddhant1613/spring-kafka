package com.spring.kafka.service;

import org.springframework.stereotype.Service;

import com.spring.kafka.utils.AppConstants;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Service
@Slf4j
public class KafkaService {
	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		log.info(String.format("Message sent -> %s", message));
		kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
	}

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.TOPIC_NAME)
	public void consumeMessage(String message) {
		// Handle the incoming message
		log.info(String.format("Message received -> %s", message));
	}

}
