package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.OptionalTopicCourseGroup;


@Repository
public interface OptionalTopicCourseGroupRepository extends JpaRepository<OptionalTopicCourseGroup,Long> {

}
