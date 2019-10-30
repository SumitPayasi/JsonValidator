package com.spring.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Rule")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rule {

	@Id
	@JsonProperty("ID")
	private int id;
	@JsonProperty("parentID")
	private int parentId;
	private int level;
	private String rule;
	private String fieldName;
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="Rule_id")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ListofRules> allRule;
	
	/*
	 * @OneToOne(cascade= {CascadeType.ALL}) private FinancialYear fy;
	 * 
	 * public FinancialYear getFy() { return fy; }
	 * 
	 * public void setFy(FinancialYear fy) { this.fy = fy; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public List<ListofRules> getAllRule() {
		return allRule;
	}

	public void setAllRule(List<ListofRules> allRule) {
		this.allRule = allRule;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", parentId=" + parentId + ", level=" + level + ", rule=" + rule + ", fieldName="
				+ fieldName + ", allRule=" + allRule + "]";
	}
	
}
