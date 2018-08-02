package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String cod;

    private String name;

    private String description;

    @OneToMany(mappedBy = "course")
    private List<CourseOffer> offers;

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
