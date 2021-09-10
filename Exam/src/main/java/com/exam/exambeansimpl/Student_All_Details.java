package com.exam.exambeansimpl;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_details")
public class Student_All_Details  {

	
	
	@Id
	@Column(nullable = false, length = 45)
	private String student_id;
	@Column(nullable = false, length = 45)
	private String student_password;
	@Column(nullable = false, length = 200)
	private String student_name;
	@Column(nullable = false, length = 45)
	private String student_fathername;
	@Column(nullable = false, length = 45)
	private String student_email;
	@Column(nullable = false, length = 45)
	private String student_phone;
	@Column(nullable = false, length = 45)
	private String student_dob;
	@Column(nullable = false, length = 45)
	private String gender;

	@Column(nullable = false, length = 46)
	private String student_state;
	@Column(nullable = false, length = 200)
	private String student_address_line_one;
	@Column(nullable = false, length = 45)
	private String student_address_line_two;
	@Column(nullable = false, length = 45)
	private String student_location;
	@Column(nullable = false, length = 45)
	private String student_nationality;
	@Column(nullable = true, length = 45 ,columnDefinition="varchar(45) default 'NA'")
	private String student_college_id;
	@Column(nullable = true, length = 100,columnDefinition="varchar(45) default 'NA'")
	private String student_college;
	@Column(nullable = false, length = 45)
	private String course;
	@Column(nullable = false, length = 45)
	private String graduation_status;
	@Column(nullable = true, length = 45,columnDefinition="varchar(45) default 'NA'")
	private String admission_year;
	@Column(nullable = true, length = 45,columnDefinition="varchar(45) default 'NA'")
	private String passout_year;

	@Column(nullable = false, length = 45)
	private String student_stream;
	@Column(nullable = false, length = 45)
	private String student_pin;
	@Column(nullable = false, length = 45)
	private String student_district;
	@Column(nullable = false, length = 45)
	private String current_date_val;
	@Column(nullable = false, length = 45)
	private String purpose;
	@Column(nullable = false, length = 45)
	private String apti_type;
	@Column(nullable = false, length = 45)
	private int exam_status;
	@Column(nullable = false, length = 45)
	private int student_status;
	
	
	
	
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	
	
	
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_fathername() {
		return student_fathername;
	}
	public void setStudent_fathername(String student_fathername) {
		this.student_fathername = student_fathername;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudent_state() {
		return student_state;
	}
	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}
	public String getStudent_address_line_one() {
		return student_address_line_one;
	}
	public void setStudent_address_line_one(String student_address_line_one) {
		this.student_address_line_one = student_address_line_one;
	}
	public String getStudent_address_line_two() {
		return student_address_line_two;
	}
	public void setStudent_address_line_two(String student_address_line_two) {
		this.student_address_line_two = student_address_line_two;
	}
	public String getStudent_location() {
		return student_location;
	}
	public void setStudent_location(String student_location) {
		this.student_location = student_location;
	}
	public String getStudent_nationality() {
		return student_nationality;
	}
	public void setStudent_nationality(String student_nationality) {
		this.student_nationality = student_nationality;
	}
	public String getStudent_college_id() {
		return student_college_id;
	}
	public void setStudent_college_id(String student_college_id) {
		this.student_college_id = student_college_id;
	}
	public String getStudent_college() {
		return student_college;
	}
	public void setStudent_college(String student_college) {
		this.student_college = student_college;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGraduation_status() {
		return graduation_status;
	}
	public void setGraduation_status(String graduation_status) {
		this.graduation_status = graduation_status;
	}
	public String getAdmission_year() {
		return admission_year;
	}
	public void setAdmission_year(String admission_year) {
		this.admission_year = admission_year;
	}
	public String getPassout_year() {
		return passout_year;
	}
	public void setPassout_year(String passout_year) {
		this.passout_year = passout_year;
	}
	public String getStudent_stream() {
		return student_stream;
	}
	public void setStudent_stream(String student_stream) {
		this.student_stream = student_stream;
	}
	public String getStudent_pin() {
		return student_pin;
	}
	public void setStudent_pin(String student_pin) {
		this.student_pin = student_pin;
	}
	public String getStudent_district() {
		return student_district;
	}
	public void setStudent_district(String student_district) {
		this.student_district = student_district;
	}
	public String getCurrent_date_val() {
		return current_date_val;
	}
	public void setCurrent_date_val(String current_date_val) {
		this.current_date_val = current_date_val;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getApti_type() {
		return apti_type;
	}
	public void setApti_type(String apti_type) {
		this.apti_type = apti_type;
	}
	public int getExam_status() {
		return exam_status;
	}
	public void setExam_status(int exam_status) {
		this.exam_status = exam_status;
	}
	public int getStudent_status() {
		return student_status;
	}
	public void setStudent_status(int student_status) {
		this.student_status = student_status;
	}

	

}
