package com.exam.examservice;

import java.util.List;

import com.exam.exambeansimpl.IT_Questions;

public interface StudentITQuestion{
	
//public List<Questions> getAllquestion(HttpServletRequest request);
	public List<IT_Questions> getAllquestion(String sesn,String apti_type);

}
