package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.BasicTopic;


@Repository
public interface BasicTopicRepository extends JpaRepository<BasicTopic,Long> {

}
