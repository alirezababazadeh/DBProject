package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {

}
