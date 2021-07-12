package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.StudentCourses;


@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses,Long> {

}
