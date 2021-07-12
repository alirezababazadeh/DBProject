package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.CourseStudent;


@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent,Long> {

}
