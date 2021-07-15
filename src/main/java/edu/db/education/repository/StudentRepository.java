package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
