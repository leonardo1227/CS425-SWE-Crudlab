package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "First Name is required!")
    @NotEmpty(message = "First Name cannot be empty!")
    private String firstName;

    private String middleName;

    @NotNull(message = "Last Name is required!")
    @NotEmpty(message = "Last Name cannot be empty!")
    private String lastName;

    @NotNull(message = "Birthdate is required!")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "person")
    private List<PersonRole> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<PersonRole> getRoles() {
        return roles;
    }

    public void setRoles(List<PersonRole> roles) {
        this.roles = roles;
    }
}
