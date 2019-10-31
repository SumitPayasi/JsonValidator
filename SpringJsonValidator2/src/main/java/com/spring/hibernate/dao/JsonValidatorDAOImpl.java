package com.spring.hibernate.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.model.Rule;

/**
 * @author sumit
 *
 */
@Repository
@Transactional
public class JsonValidatorDAOImpl extends AbstractDao<Integer, Rule> implements JsonValidatorDAO {

	private final Logger Log = LoggerFactory.getLogger(JsonValidatorDAOImpl.class);

	/**
	 *
	 */
	@Override
	public void saveRule(Rule rule) {
		Log.debug("inside JsonValidatorDAOImpl saveRule(), creating session object");
		/*
		 * List<Rule> rules = retrivefromDb(); if (rules.size()!=0)
		 * retrivefromDb().forEach(rule1 -> getSession().delete(rule1));
		 */

		getSession().saveOrUpdate(rule);
		Log.info("Rules have been saved");
	}

	/**
	* 
	*/
	@SuppressWarnings("unchecked")
	public List<Rule> retrivefromDb() {

		Log.info("Inside JsonValidatorDAOImpl retrivefromDb(), creating sessin object ");
		List<Rule> rulelist = getSession().createQuery("from Rule").list();
		Log.info("Returning List of rules from DB: {}", rulelist);
		return rulelist;
	}

}
