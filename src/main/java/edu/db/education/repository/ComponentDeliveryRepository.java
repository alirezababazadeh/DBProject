package edu.db.education.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.db.education.entity.ComponentDelivery;


@Repository
public interface ComponentDeliveryRepository extends JpaRepository<ComponentDelivery,Long> {

}
