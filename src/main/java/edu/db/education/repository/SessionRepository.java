package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.Session;


@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

}
