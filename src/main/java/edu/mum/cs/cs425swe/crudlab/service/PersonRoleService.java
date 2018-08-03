package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.PersonRole;
import edu.mum.cs.cs425swe.crudlab.repository.IPersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("personRoleService")
public class PersonRoleService implements IService<PersonRole>{

    @Autowired
    private IPersonRoleRepository personRoleRepository;


    @Override
    public List<PersonRole> findAll() {
        return personRoleRepository.findAll();
    }

    @Override
    public List<PersonRole> findAll(String orderingProperty) {
        return personRoleRepository.findAll(new Sort(Sort.Direction.ASC, orderingProperty));
    }

    @Override
    public PersonRole findById(Long id) {
        Optional<PersonRole> result = personRoleRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public PersonRole save(PersonRole personRole) {
        return personRoleRepository.save(personRole);
    }

    @Override
    public void deleteById(Long id) {
        personRoleRepository.deleteById(id);
    }
}

