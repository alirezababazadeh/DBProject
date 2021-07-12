package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.Practice;


@Repository
public interface PracticeRepository extends JpaRepository<Practice,Long> {

}
