package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "COD is required!")
    @Column(unique = true)
    private String cod;

    @NotEmpty(message = "Name is required!")
    private String name;

    @NotEmpty(message = "Description is required!")
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "course")
    private List<CourseOffer> offers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<CourseOffer> offers) {
        this.offers = offers;
    }
}
