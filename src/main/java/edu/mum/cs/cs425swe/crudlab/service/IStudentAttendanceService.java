package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.StudentAttendance;

import java.util.List;

public interface IStudentAttendanceService {
    public abstract List<StudentAttendance> findAll();
    public abstract StudentAttendance findById(Long id);
    public abstract StudentAttendance save(StudentAttendance studentAttendance);
    public abstract void deleteById(Long id);
}
