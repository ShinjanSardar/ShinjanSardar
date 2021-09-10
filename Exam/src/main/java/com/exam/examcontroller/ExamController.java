package com.exam.examcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambeansimpl.AllAnswer;
import com.exam.exambeansimpl.AllAnswerVo;
import com.exam.exambeansimpl.IT_Questions;
import com.exam.exambeansimpl.Non_IT_AllAnswer;
import com.exam.exambeansimpl.StudentLogin;
import com.exam.exambeansimpl.Student_All_Details;
import com.exam.examservice.StudentAnswer;
import com.exam.examservice.StudentDetails;
import com.exam.examservice.StudentITQuestion;


@RestController
public class ExamController {
	static final Logger logger = Logger.getLogger(ExamController.class);
	@Autowired
	StudentAnswer answerService;
	@Autowired
	StudentITQuestion questionService;
	@Autowired
	StudentDetails studentService;

	@PostMapping("/save")
	public String saveDetails(@RequestBody Student_All_Details sDetails, HttpServletResponse response) {

		String success = studentService.newCandidate(sDetails);

		try {
			if(!success.equals(null)||success=="") {
			 response.setContentType("text/javascript");
             response.getWriter().write("{success:true,successvalue:" + success + "}");
             response.getWriter().flush();
			} else {
				logger.info("failed");
			response.setContentType("text/javascript");
             response.getWriter().write("{failure:true,failurevalue:failed}");
             response.getWriter().flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping("/login")
	public String candidateLogin(@RequestBody Student_All_Details sDetails,HttpSession session) {
		StudentLogin slogin=studentService.candidateLogin(null);
		String returned_id=slogin.getCandidate_id();
		if(slogin.getConfirm()!=0 || slogin.getLogin()!=0){
		session.setAttribute("id", slogin.getCandidate_id());
		session.setAttribute("apti_type", slogin.getApti_type());
		}
		return returned_id;
	}
	@GetMapping("/exam")
	public ArrayList<IT_Questions> candidateQuestion(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String sesn = (String) session.getAttribute("id");
		String aptitype =  (String) session.getAttribute("apti_type");
		
		ArrayList<IT_Questions> returned_question=(ArrayList<IT_Questions>) questionService.getAllquestion(sesn, aptitype);
		try {
		if(returned_question.get(0).getError()!=1)
		{
			 response.setContentType("text/javascript");
             response.getWriter().write("{success:true,successvalue:" + returned_question + "}");
             response.getWriter().flush();
		
		}
		else if(returned_question.get(0).getError()==1){
			response.setContentType("text/javascript");
            response.getWriter().write("{failure:true,failurevalue:failed}");
            response.getWriter().flush();
		}
		}catch (Exception e) {
			logger.error("question exception",e);
		}
		return null;
	}
	@PostMapping("/ans")
	public String submitAnswer(@RequestBody AllAnswerVo vo,HttpServletRequest request) {
		String apti_type=null;
		String candidate_id=null;
		HttpSession session = request.getSession(false);
		apti_type=(String)session.getAttribute("apti_type");
		candidate_id=(String)session.getAttribute("id");
		String return_val=null;
		
		String[] question_no=vo.getQuestion_no();
		if(apti_type.equals("it")) {
			AllAnswer answer=new AllAnswer();
			for(int i=0;i<question_no.length;i++) {
				answer.setGenerated_id(candidate_id);
				answer.setQuestion_no(vo.getQuestion_no()[i]);
				answer.setOpt(vo.getAns_opt()[i]);
				answer.setApti_type(apti_type);
				
				return_val=answerService.answerSubmit(answer);
				
			}
		}else if(apti_type.equals("nonit")) {
			Non_IT_AllAnswer nonitanswer=new Non_IT_AllAnswer();
			for(int i=0;i<question_no.length;i++) {
				nonitanswer.setGenerated_id(candidate_id);
				nonitanswer.setQuestion_no(vo.getQuestion_no()[i]);
				nonitanswer.setOpt(vo.getAns_opt()[i]);
				nonitanswer.setApti_type(apti_type);
				
				return_val=answerService.nonitanswerSubmit(nonitanswer);
				
			}
			
			
		}
		return null;
		
	}

}

