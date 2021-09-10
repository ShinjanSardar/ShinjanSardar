package com.exam.exambeansimpl;

public class AllAnswerVo {
	
	private int sl_no;
	private String[] question_no;
	private String[] ans_opt;
	private String candidate_id;
	private String apti_type;
	
	public int getSl_no() {
		return sl_no;
	}
	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}
	public String[] getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(String[] question_no) {
		this.question_no = question_no;
	}
	public String[] getAns_opt() {
		return ans_opt;
	}
	public void setAns_opt(String[] ans_opt) {
		this.ans_opt = ans_opt;
	}
	public String getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getApti_type() {
		return apti_type;
	}
	public void setApti_type(String apti_type) {
		this.apti_type = apti_type;
	}
	
	
	

}
