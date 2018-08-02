package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.StudentAttendance;
import edu.mum.cs.cs425swe.crudlab.repository.IStudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentAttendanceService")
public class StudentAttendanceService implements  IService<StudentAttendance> {

    @Autowired
    private IStudentAttendanceRepository studentAttendanceRepository;

    @Override
    public List<StudentAttendance> findAll() {
        return studentAttendanceRepository.findAll();
    }

    @Override
    public StudentAttendance findById(Long id) {
        Optional<StudentAttendance> result = studentAttendanceRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public StudentAttendance save(StudentAttendance studentAttendance) {
        return studentAttendanceRepository.save(studentAttendance);
    }

    @Override
    public void deleteById(Long id) {
        studentAttendanceRepository.deleteById(id);
    }
}
