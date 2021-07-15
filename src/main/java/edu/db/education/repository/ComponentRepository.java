package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.Component;


@Repository
public interface ComponentRepository extends JpaRepository<Component,Long> {

}
