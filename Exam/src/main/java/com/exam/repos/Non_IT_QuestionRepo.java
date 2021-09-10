package com.exam.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.exambeansimpl.Non_IT_Questions;
@Repository
public interface Non_IT_QuestionRepo extends JpaRepository<Non_IT_Questions, Long>{
	
	
	@Query("SELECT nqt.set_num FROM Non_IT_Questions nqt")
	public ArrayList<String> getNonitSetnum();
	
	
	
	
	@Query("SELECT nqt FROM Non_IT_Questions nqt where nqt.set_num=:selected_set_no")
	public Non_IT_Questions getAllnonitQuestion(@Param("selected_set_no")String selected_set_no);

}
