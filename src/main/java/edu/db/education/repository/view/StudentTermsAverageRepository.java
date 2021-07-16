package edu.db.education.repository.view;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.db.education.entity.view.StudentTermsAverage;

@Repository
public interface StudentTermsAverageRepository extends JpaRepository<StudentTermsAverage,Long> {

}
