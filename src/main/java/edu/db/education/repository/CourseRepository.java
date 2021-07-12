package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
