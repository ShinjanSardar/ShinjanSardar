package com.exam.exambeansimpl;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;
@Entity
public class StudentAllDetails {
	
	@Id
	@NotNull
	private String studentid;
	@NotNull
	private String studentname;
	@NotNull
	private String studentfathername;
	@NotNull
	private String studentemail;
	@NotNull
	private String studentphone;
	@NotNull
	private String studentdob;
	@NotNull
	private String studentstate;
	@NotNull
	private String studentaddress;
	@NotNull
	private String studentlocation;
	@NotNull
	private String studentnationality;
	@NotNull
	private String studentcollege;
	@NotNull
	private String studentstream;
	@NotNull
	private String studentpin;
	@NotNull
	private String studentdistrict;
	
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentfathername() {
		return studentfathername;
	}
	public void setStudentfathername(String studentfathername) {
		this.studentfathername = studentfathername;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}
	public String getStudentdob() {
		return studentdob;
	}
	public void setStudentdob(String studentdob) {
		this.studentdob = studentdob;
	}
	public String getStudentstate() {
		return studentstate;
	}
	public void setStudentstate(String studentstate) {
		this.studentstate = studentstate;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public String getStudentlocation() {
		return studentlocation;
	}
	public void setStudentlocation(String studentlocation) {
		this.studentlocation = studentlocation;
	}
	public String getStudentnationality() {
		return studentnationality;
	}
	public void setStudentnationality(String studentnationality) {
		this.studentnationality = studentnationality;
	}
	public String getStudentcollege() {
		return studentcollege;
	}
	public void setStudentcollege(String studentcollege) {
		this.studentcollege = studentcollege;
	}
	public String getStudentstream() {
		return studentstream;
	}
	public void setStudentstream(String studentstream) {
		this.studentstream = studentstream;
	}
	public String getStudentpin() {
		return studentpin;
	}
	public void setStudentpin(String studentpin) {
		this.studentpin = studentpin;
	}
	public String getStudentdistrict() {
		return studentdistrict;
	}
	public void setStudentdistrict(String studentdistrict) {
		this.studentdistrict = studentdistrict;
	}
	
	
	

}
