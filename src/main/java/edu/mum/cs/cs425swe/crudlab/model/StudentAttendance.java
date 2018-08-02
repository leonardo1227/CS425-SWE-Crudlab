package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentAttendance {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CourseOffer courseOffer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    public void setCourseOffer(CourseOffer courseOffer) {
        this.courseOffer = courseOffer;
    }
}
