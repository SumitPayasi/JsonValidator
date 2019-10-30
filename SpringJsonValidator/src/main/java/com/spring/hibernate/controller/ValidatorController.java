package com.spring.hibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hibernate.model.Rule;
import com.spring.hibernate.service.JsonValidatorService;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class ValidatorController {

	@Autowired
	private JsonValidatorService jsonValidatorService;
	private static final Logger Log = LoggerFactory.getLogger(ValidatorController.class);

	@PostMapping(path = "/saves", consumes = "application/json", produces = "appliation/json")
	public ResponseEntity<String> saveRule(@RequestBody List<Rule> rules) {
		Log.info("Inside ValidatorController's saveRule method, passing json: {}", rules);
		rules.forEach(rule -> {
			jsonValidatorService.saveRule(rule);
		});
		Log.info("Saved whole json in dabase and exiting from saveRule method");

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/fetchfromDb")
	@ResponseBody
	public List<Rule> retrivefromDb() {
		Log.info("Inside ValidatorController retrivefromDb medhod");
		List<Rule> rules = jsonValidatorService.retrivefromDb();
		Log.info("Exiting retrivefromDb method returning json response: {} ", rules);
		return rules;
	}
}
