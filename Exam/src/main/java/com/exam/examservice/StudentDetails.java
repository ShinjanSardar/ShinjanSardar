package com.exam.examservice;


import com.exam.exambeansimpl.StudentLogin;
import com.exam.exambeansimpl.Student_All_Details;

public interface StudentDetails {
	public String newCandidate(Student_All_Details sDetails);
	public String generateID();
	public StudentLogin candidateLogin(Student_All_Details sDetails);
	//public List<Questions> getAllquestion();
	
	//public int repeatExams(String student_id,String current_date_val);
	
}
