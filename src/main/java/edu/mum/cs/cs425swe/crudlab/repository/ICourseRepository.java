package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
