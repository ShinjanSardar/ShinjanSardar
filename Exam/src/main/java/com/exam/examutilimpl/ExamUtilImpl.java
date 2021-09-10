package com.exam.examutilimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.exam.examutil.ExamUtil;
import com.exam.repos.StudentRepo;

public class ExamUtilImpl implements ExamUtil {
	@Autowired
	StudentRepo stRepo;

	static final Logger logger = Logger.getLogger(ExamUtilImpl.class);

	@Override
	public String getTodaydat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String cdate = dtf.format(now);
		return cdate;
	}

	@Override
	public int dateCheck() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String encryptPassword(String pass) {
		String passwordToHash = pass;
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error("algorithm exception" + " " + e);
		}
		logger.info(generatedPassword);
		return generatedPassword;
	}

	public int repeatExams(String student_id, String current_date_val) {
		int j = 0;
		try {

			String stdid = student_id;

			String date = current_date_val;// 15/08/2020
			LocalDate date1 = LocalDate.parse(date);// 15/08/2020
			LocalDate returnvalue = date1.plusMonths(3);// 15/11/2020
			// System.out.println(returnvalue);

			if (returnvalue.isAfter(java.time.LocalDate.now()))// 15/09/2020>16/06/2020
			{

				j = j + 0;
			}

			else {
				int exam_status = 0;
				int student_status = 0;

				int success = stRepo.updateStudent(exam_status, student_status, student_id);
				if (success == 1) {

					j = j + 1;

				}
			}

		} catch (Exception x) {
			x.printStackTrace();
			logger.error("RepeatExam exception", x);

		}
		return j;

	}

}
