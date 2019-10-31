package com.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Choice")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Choice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int choiceId;
	@JsonProperty("key")
	private String key1;
	@JsonProperty("value")
	private String value1;
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public Choice() {
		super();
	}
	@Override
	public String toString() {
		return "Choice [choiceId=" + choiceId + ", key1=" + key1 + ", value1=" + value1 + "]";
	}


}
