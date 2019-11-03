/**
 * 
 */
package com.spring.hibernate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.JsonValidatorDAO;
import com.spring.hibernate.model.Rule;

/**
 * @author admin
 *
 */
@Service
public class JsonValidatorServiceImpl implements JsonValidatorService {

	@Autowired
	private JsonValidatorDAO jsonValidatorDAO;

	private static final Logger Log = LoggerFactory.getLogger(JsonValidatorServiceImpl.class);
	@Transactional
	public void saveRule(Rule rule) {
		
		Log.info("Insode JsonValidatorServiceImpl class saveRule()");
		Log.info("saving Request data into db :{}",rule);
		jsonValidatorDAO.saveRule(rule);
		Log.info("Exiting saveRule()");
	}

	
	public void saveRule(Rule rule, String formName) {
		jsonValidatorDAO.saveRule(rule,formName);
	}
	 

	@Override
	public List<Rule> retrivefromDb() {
		Log.info("Insode JsonValidatorServiceImpl class retrivefromDb()");
		Log.info("fetching data from DB");
		List<Rule> list = jsonValidatorDAO.retrivefromDb();
		Log.info("Exiting JsonValidatorServiceImpl retrivefromDb()");
		return list;
	}

}
