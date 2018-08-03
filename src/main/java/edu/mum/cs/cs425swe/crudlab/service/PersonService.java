package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Person;
import edu.mum.cs.cs425swe.crudlab.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("personService")
public class PersonService implements IService<Person> {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAll(String orderingProperty) {
        return personRepository.findAll(new Sort(Sort.Direction.ASC, orderingProperty));
    }

    @Override
    public Person findById(Long id) {
        Optional<Person> result = personRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    /*public List<Person> findByFirstNameAndMiddleNameAndLastNameAndBirthDate(String fisrtName, String middleName, String lastName, LocalDate birthdate){
        return personRepository.findByFirstNameAAndMiddleNameAndLastNameAndBirthdate(fisrtName,middleName,lastName,birthdate);
    }*/
}
