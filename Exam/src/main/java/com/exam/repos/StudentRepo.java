package com.exam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.exambeansimpl.IDMaster;
import com.exam.exambeansimpl.Student_All_Details;
@Repository
public interface StudentRepo extends  JpaRepository<Student_All_Details, String> {
	
//	@Modifying(clearAutomatically = true)// can return only void and int.
	@Query("select idm from IDMaster idm where idm.identifier=:prefix")
	public IDMaster getId(@Param("prefix") String prefix);
	
	@Transactional
	@Modifying(clearAutomatically = true)// can return only void and int.
	@Query("update IDMaster idm  set idm.current_number=:currentno where idm.identifier=:prefix")
	public int updateIdmaster(@Param("currentno") int newcurrent_no, @Param("prefix") String prefix);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Student_All_Details st set st.exam_status=:exam_status,st.student_status=:student_status where st.student_id=:student_id")
	public int updateStudent(@Param("exam_status")int exam_status, @Param("student_status")int student_status,@Param("student_id") String student_id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Student_All_Details st set st.exam_status=:exam_status,st.exam_date=:examdate where st.student_id=:student_id")
	public int updateExamstatus(@Param("exam_status")int exam_status, @Param("examdate")String examdate,@Param("student_id") String student_id);
	
	
}
