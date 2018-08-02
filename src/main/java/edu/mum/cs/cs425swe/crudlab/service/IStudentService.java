package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Student;

import java.util.List;

public interface IStudentService {
    public abstract List<Student> findAll();
    public abstract Student findById(Long id);
    public abstract Student save(Student student);
    public abstract void deleteById(Long id);
}
