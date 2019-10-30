package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.model.Rule;

public interface JsonValidatorDAO {
	
	void saveRule(Rule rule);

	List<Rule> retrivefromDb();
	/* void deleteAll(); */

}
