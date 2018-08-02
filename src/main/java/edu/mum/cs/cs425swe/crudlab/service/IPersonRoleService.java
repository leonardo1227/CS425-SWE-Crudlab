package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.PersonRole;

import java.util.List;

public interface IPersonRoleService {
    public abstract List<PersonRole> findAll();
    public abstract PersonRole findById(Long id);
    public abstract PersonRole save(PersonRole personRole);
    public abstract void deleteById(Long id);
}
