package com.spring.hibernate.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {

	public static void main(String[] args) {
		/*
		 * ObjectMapper object = new ObjectMapper(); List<Rule> rule=null; try { rule =
		 * object.readValue(new File("C:\\jsonfile\\rule1.json"), new
		 * TypeReference<List<Rule>>(){}); }catch (Exception e) { e.printStackTrace(); }
		 * System.out.println(rule);
		 */

		ObjectMapper object = new ObjectMapper();
		List<Rule> rule = null;
		String arraytoJson=null;
		try {
			//rule =Arrays. asList(object.readValue(new File("C:\\jsonfile\\rule1.json"), Rule[].class)) ;
			rule =Arrays. asList(object.readValue(new File("C:\\jsonfile\\rule1.json"), Rule[].class)) ;
		arraytoJson=object.writeValueAsString(rule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(arraytoJson);
	}

}
