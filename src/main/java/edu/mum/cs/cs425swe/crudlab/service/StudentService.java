package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.Person;
import edu.mum.cs.cs425swe.crudlab.model.Student;
import edu.mum.cs.cs425swe.crudlab.repository.IPersonRepository;
import edu.mum.cs.cs425swe.crudlab.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentService implements IService<Student> {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAll(String orderingProperty) {
        return studentRepository.findAll(new Sort(Sort.Direction.ASC, orderingProperty));
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> result = studentRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Student save(Student student) {
        Person person = personRepository.save(student.getPerson());
        student.setPerson(person);
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
