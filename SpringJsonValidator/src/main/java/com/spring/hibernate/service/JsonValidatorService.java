package com.spring.hibernate.service;

import java.util.List;

import com.spring.hibernate.model.Rule;

public interface JsonValidatorService {

	void saveRule(Rule rule);

	List<Rule> retrivefromDb();

}
