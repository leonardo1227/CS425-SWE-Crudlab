package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Faculty;
import edu.mum.cs.cs425swe.crudlab.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("facultyService")
public class FacultyService implements IService<Faculty> {

    @Autowired
    private IFacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Long id) {
        Optional<Faculty> result = facultyRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }
}
