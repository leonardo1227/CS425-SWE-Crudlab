package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentAttendanceRepository")
public interface IStudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {
}
