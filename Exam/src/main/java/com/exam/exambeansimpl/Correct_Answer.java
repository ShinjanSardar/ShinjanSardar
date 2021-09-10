package com.exam.exambeansimpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Correct_Answer {
	@Column(nullable = false, length = 4)
	private String q_id;
	@Id
	@Column(nullable = false, length = 4)
	private String ans_no;
	@Column(nullable = false, length = 2)
	private String correct_anskey;

	public String getQ_id() {
		return q_id;
	}

	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}

	public String getAns_no() {
		return ans_no;
	}

	public void setAns_no(String ans_no) {
		this.ans_no = ans_no;
	}

	public String getCorrect_anskey() {
		return correct_anskey;
	}

	public void setCorrect_anskey(String correct_anskey) {
		this.correct_anskey = correct_anskey;
	}

}
