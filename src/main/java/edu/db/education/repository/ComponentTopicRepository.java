package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.ComponentTopic;


@Repository
public interface ComponentTopicRepository extends JpaRepository<ComponentTopic,Long> {

}
