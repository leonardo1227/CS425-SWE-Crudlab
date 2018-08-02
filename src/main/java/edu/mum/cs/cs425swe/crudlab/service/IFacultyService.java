package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Faculty;

import java.util.List;

public interface IFacultyService {
    public abstract List<Faculty> findAll();
    public abstract Faculty findById(Long id);
    public abstract Faculty save(Faculty faculty);
    public abstract void deleteById(Long id);
}
