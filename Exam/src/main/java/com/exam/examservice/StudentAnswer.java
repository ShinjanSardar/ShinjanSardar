package com.exam.examservice;

import com.exam.exambeansimpl.AllAnswer;
import com.exam.exambeansimpl.Non_IT_AllAnswer;

public interface StudentAnswer {
	
	//public String answerSubmit(AllAnswer ans,String candidate_id,String apti_type);
	public String answerSubmit(AllAnswer ans);

	public String nonitanswerSubmit(Non_IT_AllAnswer nonitanswer);
	

}
