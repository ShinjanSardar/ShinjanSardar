package com.exam.exambeansimpl;

//@Entity
public class StudentLogin {
	
//	@Id
//	@Transient
	private String candidate_id;
	//@Transient
	private String candidate_password;
	//@Transient
	private String apti_type;
	//@Transient
	private int confirm;
	//@Transient
	private int login;
	
	
	
	
	public String getApti_type() {
		return apti_type;
	}
	public void setApti_type(String apti_type) {
		this.apti_type = apti_type;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public String getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getCandidate_password() {
		return candidate_password;
	}
	public void setCandidate_password(String candidate_password) {
		this.candidate_password = candidate_password;
	}
	
	

}
