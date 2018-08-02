package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CourseOffer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "courseOffer")
    private List<StudentAttendance> attendances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<StudentAttendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<StudentAttendance> attendances) {
        this.attendances = attendances;
    }
}
