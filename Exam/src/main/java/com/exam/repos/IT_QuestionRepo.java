package com.exam.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.exambeansimpl.IT_Questions;
@Repository
public interface IT_QuestionRepo extends JpaRepository<IT_Questions, Long>{
	
	@Query("SELECT qt.set_num FROM IT_Questions qt")
	public ArrayList<String> getSetnum();
	
	
	
	
	@Query("SELECT qt FROM IT_Questions qt where qt.set_num=:set_no")
	public IT_Questions getAllQuestion(@Param("set_no")String selected_set_no);
	
	

}
