package com.exam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.exambeansimpl.AllAnswer;
import com.exam.exambeansimpl.Scores;
@Repository
public interface AnswerRepo extends JpaRepository<AllAnswer, Long> {
	
	@Query("SELECT std.std_id,count( ca.q_id)  as `score`"
			+ " from AllAnswer itans left join Correct_Answer ca on itans.question_no = ca.q_id and "
			+ "itans.opt=ca.correct_ans_key inner join Student_All_Detail std on std.studentid = itans.generated_id where std.studentid = :id")
	public Scores getScores(@Param("id") String candidate_id);
	
	//@Query()
	public void save(Scores candidate_score);

}
