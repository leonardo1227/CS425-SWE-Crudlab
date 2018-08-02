package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Faculty extends PersonRole{

    private String facultyId;

    @OneToMany(mappedBy = "faculty")
    private List<CourseOffer> courseOffers;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public List<CourseOffer> getCourseOffers() {
        return courseOffers;
    }

    public void setCourseOffers(List<CourseOffer> courseOffers) {
        this.courseOffers = courseOffers;
    }
}
