package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.CourseGroup;


@Repository
public interface CourseGroupRepository extends JpaRepository<CourseGroup,Long> {

}
