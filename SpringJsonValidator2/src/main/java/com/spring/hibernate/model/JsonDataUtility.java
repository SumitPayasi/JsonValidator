package com.spring.hibernate.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataUtility {

	private static final Logger Log = LoggerFactory.getLogger(JsonDataUtility.class);

	public static String ObjecttoJson(List<Rule> rules) {
		String jsonStr = null;
		ObjectMapper Obj = new ObjectMapper();
		try {
			jsonStr = Obj.writeValueAsString(rules);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static void createJsonFile(List<Rule> rules) {

		File file = new File("C:\\jsonfile\\rule1.json");
		Log.info("File created at: {} ", file.getAbsolutePath());
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			System.out.println("-----------------------------------:");
			fos.write(ObjecttoJson(rules).getBytes());
			fos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(ObjecttoJson(rules));
	}

	// with formname
	public static String ObjecttoJson(List<Rule> rules, String formName) {
		String jsonStr = null;
		ObjectMapper Obj = new ObjectMapper();
		try {
			jsonStr = Obj.writeValueAsString(rules);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static void createJsonFile(List<Rule> rules, String formName) {

		File file = new File("C:\\jsonfile\\" + formName + ".json");
		Log.info("File created at: {} ", file.getAbsolutePath());
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(ObjecttoJson(rules, formName).getBytes());
			fos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(ObjecttoJson(rules));
	}

//without formname
	public static List<Rule> jsontoObject() {

		ObjectMapper object = new ObjectMapper();
		List<Rule> rule = null;
		try {
			rule = Arrays.asList(object.readValue(new File("C:\\jsonfile\\rule1.json"), Rule[].class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rule;
	}

	// with formname parameter
	public static List<Rule> jsontoObject(String formname) {

		ObjectMapper object = new ObjectMapper();
		List<Rule> rule = null;
		try {
			rule = Arrays.asList(object.readValue(new File("C:\\jsonfile\\" + formname + ".json"), Rule[].class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rule;
	}
}
