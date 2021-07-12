package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.OptionalTopic;


@Repository
public interface OptionalTopicRepository extends JpaRepository<OptionalTopic,Long> {

}
