package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("facultyRepository")
public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
}
