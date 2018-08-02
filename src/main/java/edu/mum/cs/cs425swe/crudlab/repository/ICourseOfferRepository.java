package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.CourseOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseOfferRepository")
public interface ICourseOfferRepository extends JpaRepository<CourseOffer, Long> {
}
