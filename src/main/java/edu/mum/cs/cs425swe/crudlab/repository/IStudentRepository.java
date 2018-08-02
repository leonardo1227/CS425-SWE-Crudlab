package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
