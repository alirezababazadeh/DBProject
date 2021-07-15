package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
