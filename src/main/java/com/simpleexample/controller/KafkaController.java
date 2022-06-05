package com.simpleexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleexample.model.SimpleModel;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	private KafkaTemplate<String, SimpleModel> kafkaTemplate;
	
	@Autowired
	public KafkaController(KafkaTemplate<String, SimpleModel> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping
	public void post(@RequestBody SimpleModel simpleModel) {
		kafkaTemplate.send("myTopic", simpleModel);
	}
}
