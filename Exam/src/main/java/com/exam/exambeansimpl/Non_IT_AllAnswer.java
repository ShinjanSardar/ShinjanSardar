package com.exam.exambeansimpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nonit_std_ans_table")
public class Non_IT_AllAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, nullable = false)
	private int sl_no;
	@Column(length = 45, nullable = false, name = "q_id")
	private String question_no;
	@Column(length = 45, nullable = false, name = "ans_key")
	private String opt;
	@Column(length = 45, nullable = false)
	private String generated_id;
	@Column(length = 45, nullable = false)
	private String apti_type;
	
	
	
	
	
	public String getApti_type() {
		return apti_type;
	}

	public void setApti_type(String apti_type) {
		this.apti_type = apti_type;
	}

	public int getSl_no() {
		return sl_no;
	}

	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}

	public String getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(String question_no) {
		this.question_no = question_no;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getGenerated_id() {
		return generated_id;
	}

	public void setGenerated_id(String generated_id) {
		this.generated_id = generated_id;
	}

}
