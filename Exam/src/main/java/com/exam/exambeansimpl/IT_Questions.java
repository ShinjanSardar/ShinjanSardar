package com.exam.exambeansimpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "question_table")
public class IT_Questions  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(nullable = false, length = 11)
	private int q_no;
	
	@Column(nullable = false,length = 200)
	private String question;
	
	@Column(nullable = false,length = 45)
	private String Opt_one;
	
	@Column(nullable = false,length = 45)
	private String Opt_two;
	
	@Column(nullable = false,length = 45)
	private String Opt_three;
	
	@Column(nullable = false,length = 45)
	private String Opt_four;
	
	@Column(nullable = false,length = 45)
	private String Opt_five;
	
	@Column(nullable = false,length = 11)
	private String set_num;

	@Column(nullable = false,length = 10)
	private String category;
	@Transient
	private int error;
	
	
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getSet_num() {
		return set_num;
	}
	public void setSet_num(String set_num) {
		this.set_num = set_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt_one() {
		return Opt_one;
	}
	public void setOpt_one(String opt_one) {
		Opt_one = opt_one;
	}
	public String getOpt_two() {
		return Opt_two;
	}
	public void setOpt_two(String opt_two) {
		Opt_two = opt_two;
	}
	public String getOpt_three() {
		return Opt_three;
	}
	public void setOpt_three(String opt_three) {
		Opt_three = opt_three;
	}
	public String getOpt_four() {
		return Opt_four;
	}
	public void setOpt_four(String opt_four) {
		Opt_four = opt_four;
	}
	public String getOpt_five() {
		return Opt_five;
	}
	public void setOpt_five(String opt_five) {
		Opt_five = opt_five;
	}
	
	
	
}
