package edu.db.education.repository.view;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.view.StudentComponents;

@Repository
public interface StudentComponentsRepository extends JpaRepository<StudentComponents,Long> {

}
