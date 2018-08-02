package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Person;

import java.util.List;

public interface IPersonService {
    public abstract List<Person> findAll();
    public abstract Person findById(Long id);
    public abstract Person save(Person person);
    public abstract void deleteById(Long id);
}
