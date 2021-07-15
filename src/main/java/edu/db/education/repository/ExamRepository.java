package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {

}
