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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hibernate.model.JsonDataUtility;
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
		JsonDataUtility.createJsonFile(rules);

		/*
		 * rules.forEach(rule -> { JsonDataUtility.createJsonFile(rule);
		 * //jsonValidatorService.saveRule(rule); });
		 */
		Log.info("Saved whole json in dabase and exiting from saveRule method");

		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping(path = "/saves1/{formName}", consumes = "application/json", produces = "appliation/json")
	public ResponseEntity<String> saveRule1(@RequestBody List<Rule> rules, @PathVariable String formName) {
		Log.info("Recieved Post Request to save data in File");
		Log.info("Inside ValidatorController's saveRule method, passing json: {}", rules);
		JsonDataUtility.createJsonFile(rules,formName);

		/*
		 * rules.forEach(rule -> { JsonDataUtility.createJsonFile(rule);
		 * //jsonValidatorService.saveRule(rule); });
		 */
		Log.info("Saved whole json in dabase and exiting from saveRule method");

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PostMapping(path = "/saves/{formName}", consumes = "application/json", produces = "appliation/json")
	public ResponseEntity<String> saveRule(@RequestBody List<Rule> rules, @PathVariable String formName) {
		Log.info("Inside ValidatorController's saveRule method, passing json: {}", rules);
		// JsonDataUtility.createJsonFile(rules);

		rules.forEach(rule -> {
			
			jsonValidatorService.saveRule(rule,formName);
		});

		Log.info("Saved whole json in dabase and exiting from saveRule method");

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/fetchfromDb")
	@ResponseBody
	public List<Rule> retrivefromDb() {
		Log.info("Inside ValidatorController retrivefromDb medhod");
		List<Rule> rules = JsonDataUtility.jsontoObject();
		Log.info("Exiting retrivefromDb method returning json response: {} ", rules);
		return rules;
		
		
		/*
		 * Log.info("Inside ValidatorController retrivefromDb medhod"); List<Rule> rules
		 * = jsonValidatorService.retrivefromDb();
		 * Log.info("Exiting retrivefromDb method returning json response: {} ", rules);
		 * return rules;
		 */
	}
	@GetMapping(path = "/fetchfromDb/{formName}")
	@ResponseBody
	public List<Rule> retrivefromDb(@PathVariable String formName) {
		Log.info("Recieved Get Request to fetch data from File");
		Log.info("Inside ValidatorController retrive method medhod");
		List<Rule> rules = JsonDataUtility.jsontoObject(formName);
		Log.info("Exiting retrivefromDb method returning json response: {} ", rules);
		return rules;
		
		
		/*
		 * Log.info("Inside ValidatorController retrivefromDb medhod"); List<Rule> rules
		 * = jsonValidatorService.retrivefromDb();
		 * Log.info("Exiting retrivefromDb method returning json response: {} ", rules);
		 * return rules;
		 */
	}
}
