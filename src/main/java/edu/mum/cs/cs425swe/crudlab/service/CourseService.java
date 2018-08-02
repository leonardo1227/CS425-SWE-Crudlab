package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Course;
import edu.mum.cs.cs425swe.crudlab.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseService")
public class CourseService implements IService<Course>{

    @Autowired
    private ICourseRepository courseRepository;


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null);
    }


    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
