package com.exam.examserviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambeansimpl.IDMaster;
import com.exam.exambeansimpl.StudentLogin;
import com.exam.exambeansimpl.Student_All_Details;
import com.exam.examservice.StudentDetails;
import com.exam.examutilimpl.ExamUtilImpl;
import com.exam.repos.StudentRepo;

@Service
public class StudentService implements StudentDetails {
	static final Logger logger = Logger.getLogger(StudentService.class);
	@Autowired
	StudentRepo studentRepo;
	
	
	ExamUtilImpl eutil=new ExamUtilImpl();

	@Override
	public String newCandidate(Student_All_Details sDetails) {
		try {
			// Id generate
			String generated_id = generateID();
			sDetails.setStudent_id(generated_id.trim());

			// today's date
			ExamUtilImpl eutil = new ExamUtilImpl();
			sDetails.setCurrent_date_val(eutil.getTodaydat().trim());
			// password
			String encPassword = eutil.encryptPassword(sDetails.getStudent_dob());
			sDetails.setStudent_password(encPassword.trim());

			Student_All_Details details = studentRepo.save(sDetails);
			if (!details.getStudent_id().equals(null)) {
				return details.getStudent_id();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String generateID() {
		String generated_id = null;
		try {
			Date d = new Date();

			// System.out.println(cdate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String year = sdf.format(d);
			String prefix = "PCS";

			int newcurrent_no = 0;
			String currentno = null;

			IDMaster master = studentRepo.getId(prefix);

			int current_no = master.getCurrent_number();
			System.out.println("current_no::" + current_no);
			System.out.println("getIncriment::" + master.getIncrement());
			newcurrent_no = current_no + master.getIncrement();

			if (newcurrent_no <= 999999) {
				currentno = String.format("%05d", newcurrent_no);
				generated_id = prefix.concat(year).concat(currentno);
			}
			System.out.println("generated_id::" + generated_id);

			int success = studentRepo.updateIdmaster(newcurrent_no, prefix);
			System.out.println("success::" + success);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generated_id;
	}

	@Override
	public StudentLogin candidateLogin(Student_All_Details sDetails) {
		int count = 0;
		int confirm = 0;
		ExamUtilImpl eutil = new ExamUtilImpl();
		StudentLogin login=new StudentLogin();
		Student_All_Details returnObject = studentRepo.getById(sDetails.getStudent_id());
		if (returnObject.getStudent_password().equals(sDetails.getStudent_password())) {
			count++;
			int exam_status = returnObject.getExam_status();
			if (exam_status != 0) {
				confirm = eutil.repeatExams(returnObject.getStudent_id(), returnObject.getCurrent_date_val());
				logger.info("confirm==" + confirm);
				// checking student has
				if (confirm == 0) {
					
					login.setConfirm(0);
					return login;

				}

				else {

					if (count == 1) {
						login.setApti_type(returnObject.getApti_type());
						login.setCandidate_id(returnObject.getStudent_id());
						logger.info("Login successfull");

						return login;

						

					} else {
						
					}

				}
			} else if (count == 1) {

				login.setApti_type(returnObject.getApti_type());
				login.setCandidate_id(returnObject.getStudent_id());

				return login;

			} else {
				logger.info("Login successfull");
				login.setLogin(0);
				return login;
			}

		}

		return null;
	}


	

	

	

}
