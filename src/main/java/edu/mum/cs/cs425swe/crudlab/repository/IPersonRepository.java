package edu.mum.cs.cs425swe.crudlab.repository;

import edu.mum.cs.cs425swe.crudlab.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("personRepository")
public interface IPersonRepository extends JpaRepository<Person, Long> {

//    List<Person> findByFirstNameAAndMiddleNameAndLastNameAndBirthdate(String firstName, String middleName, String lastName, LocalDate birthDate);

}
