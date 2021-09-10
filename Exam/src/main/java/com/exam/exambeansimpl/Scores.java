package com.exam.exambeansimpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_scores")
public class Scores {
	@Id
	@Column(nullable = false, length = 45)
	private String student_id;
	@Column(nullable = false, length = 11)
	private int score;
	@Column(nullable = false, length = 45)
	private String registered_date;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRegistered_date() {
		return registered_date;
	}

	public void setRegistered_date(String registered_date) {
		this.registered_date = registered_date;
	}

}
