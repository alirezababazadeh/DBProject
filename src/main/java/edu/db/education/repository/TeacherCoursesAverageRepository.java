package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.TeacherCoursesAverage;


@Repository
public interface TeacherCoursesAverageRepository extends JpaRepository<TeacherCoursesAverage,Long> {

}
