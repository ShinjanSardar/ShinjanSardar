package com.exam.examserviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambeansimpl.AllAnswer;
import com.exam.exambeansimpl.Non_IT_AllAnswer;
import com.exam.exambeansimpl.Scores;
import com.exam.examservice.StudentAnswer;
import com.exam.examutilimpl.ExamUtilImpl;
import com.exam.repos.AnswerRepo;
import com.exam.repos.StudentRepo;

@Service
public class AnswerService implements StudentAnswer {
	@Autowired
	AnswerRepo ansRepo;
	@Autowired
	StudentRepo stdrepo;
	static final Logger logger = Logger.getLogger(AnswerService.class);

	@Override
	// public String answerSubmit(AllAnswer ans,String candidate_id,String apti_type)
	public String answerSubmit(AllAnswer ans) {
		ExamUtilImpl dateutil=new ExamUtilImpl();
		AllAnswer return_val = ansRepo.save(ans);
		String candidate_id = return_val.getGenerated_id();
		Scores candidate_score=new Scores();
		if (candidate_id.equals(ans.getGenerated_id())) {
			logger.info("Success.Answer submitted");
			int success=stdrepo.updateExamstatus(1,dateutil.getTodaydat(), candidate_id);
			if(success==1) {
				candidate_score=ansRepo.getScores(candidate_id);
				ansRepo.save(candidate_score);
				
			}
		}

		return null;
	}

	@Override
	public String nonitanswerSubmit(Non_IT_AllAnswer nonitanswer) {
		return null;

	}

}
