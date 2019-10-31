package com.spring.hibernate.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataUtility {

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
		  FileOutputStream fos; try { fos = new FileOutputStream(file);
		  System.out.println("-----------------------------------:");
		  fos.write(ObjecttoJson(rules).getBytes());
		  fos.flush();
		  
		  } catch (IOException e) { e.printStackTrace(); }
		System.out.println(ObjecttoJson(rules));
	}
		

}
