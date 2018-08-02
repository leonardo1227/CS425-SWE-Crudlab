package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Course;

import java.util.List;

public interface ICourseService {
    public abstract List<Course> findAll();
    public abstract Course findById(Long id);
    public abstract Course save(Course course);
    public abstract void deleteById(Long id);
}
