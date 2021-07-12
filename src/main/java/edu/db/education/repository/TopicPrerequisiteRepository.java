package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.TopicPrerequisite;


@Repository
public interface TopicPrerequisiteRepository extends JpaRepository<TopicPrerequisite,Long> {

}
