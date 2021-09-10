//package com.exam.examserviceimpl;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.exam.exambeansimpl.IT_Questions;
//import com.exam.examservice.StudentITQuestion;
//import com.exam.examservice.StudentNonITQuestion;
//import com.exam.repos.IT_QuestionRepo;
//@Service
//public class Non_IT_QuestionService implements StudentNonITQuestion {
//	@Autowired
//	IT_QuestionRepo qreRepo;
//	
//	static final Logger logger = Logger.getLogger(Non_IT_QuestionService.class);
//	
//	@Override
//	public ArrayList<IT_Questions> getAllquestion(String sesn,String aptitype) {
//		ArrayList<IT_Questions> Questionlist = new ArrayList<IT_Questions>();
//		ArrayList<String> setList=null;
//		IT_Questions ques=new IT_Questions();
//		
//		
//		
//		if (sesn != null) {
//			
////			String setsql = null;
////			String questionsql = null;
//			try {
//				
//				  
//				logger.info(aptitype);
//				
//				if (aptitype.equals("it")) {	
//					setList=qreRepo.getSetnum();
//				}else if (aptitype.equals("nonit")) {
//					setList=qreRepo.getNonitSetnum();
//				}
//				
//				logger.info(setList);
//
//				Collections.shuffle(setList);
//
//				logger.info(setList);
//
//				Random random = new Random();
//
//				// lets get 5 random elements from ArrayList
//				String selected_set_no = "";
//				for (int i = 0; i < setList.size(); i++) {
//
//					if (i == 1) {
//						break;
//					}
//
//					selected_set_no = setList.get(random.nextInt(setList.size()));
//
//					logger.info("Selected set no:" + selected_set_no);
//				}
//
//				setList.clear();
//				logger.info(setList);
//				if (aptitype.equals("it")) {
//
//					 ques =qreRepo.getAllQuestion(selected_set_no);
//					 ques.setError(0);
//					 Questionlist.add(ques);
//					
//				} else if (aptitype.equals("nonit")) {	
//					
//					 ques =qreRepo.getAllnonitQuestion(selected_set_no);
//					 ques.setError(0);
//					 Questionlist.add(ques);
//				}
//				
//				
//				Collections.shuffle(Questionlist);
//
////				request.setAttribute("ls", ls);
////				request.setAttribute("set", selected_set_no);
////				request.getRequestDispatcher("/exams.jsp").forward(request, response);
//				//return Questionlist;
//				
//			} catch (Exception e) {
//
//				//e.printStackTrace();
//				logger.error("Question exception", e);
//			} 
//
//		} else {
//			//response.sendRedirect("login.jsp");
//			ques.setError(1);
//			Questionlist.add(ques);
//		}
//		
//		return Questionlist;
//	}
//
//}
