package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.SessionTopic;


@Repository
public interface SessionTopicRepository extends JpaRepository<SessionTopic,Long> {

}
