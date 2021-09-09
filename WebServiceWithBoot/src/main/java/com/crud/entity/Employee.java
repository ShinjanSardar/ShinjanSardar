package com.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, nullable = false)
	private int employee_id;
//	@Id
//	@Column(length = 45, nullable = false)
//	private String employee_id;
	

	//@Column(length = 45, nullable = false)
	private String employee_name;
	//@Column(length = 45, nullable = false)
	private String employee_emialid;
	//@Column(length = 45, nullable = false)
	private String employee_contact;
//	@Column(length = 45, nullable = false)
	private String employee_salary;

//	public int getEmployee_slno() {
//		return employee_slno;
//	}
//
//	public void setEmployee_slno(int employee_slno) {
//		this.employee_slno = employee_slno;
//	}

//	public String getEmployee_id() {
//		return employee_id;
//	}
//
//	public void setEmployee_id(String employee_id) {
//		this.employee_id = employee_id;
//	}
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getEmployee_name() {
		return employee_name;
	}

	

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_emialid() {
		return employee_emialid;
	}

	public void setEmployee_emialid(String employee_emialid) {
		this.employee_emialid = employee_emialid;
	}

	public String getEmployee_contact() {
		return employee_contact;
	}

	public void setEmployee_contact(String employee_contact) {
		this.employee_contact = employee_contact;
	}

	public String getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(String employee_salary) {
		this.employee_salary = employee_salary;
	}

}
