package com.exam.exambeansimpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idmaster")
public class IDMaster {
	@Id
	@Column(nullable = false, length = 45)
	private String identifier;
	@Column(nullable = false, length = 45)
	private int current_number;
	@Column(nullable = false, length = 255)
	private String end_range;
	@Column(nullable = false, length = 11)
	private int increment;
	@Column(nullable = false, length = 45)
	private String prefix;
	@Column(nullable = false, length = 255)
	private String start_range;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getCurrent_number() {
		return current_number;
	}

	public void setCurrent_number(int current_number) {
		this.current_number = current_number;
	}

	public String getEnd_range() {
		return end_range;
	}

	public void setEnd_range(String end_range) {
		this.end_range = end_range;
	}

	

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getStart_range() {
		return start_range;
	}

	public void setStart_range(String start_range) {
		this.start_range = start_range;
	}

}
