package edu.mum.cs.cs425swe.crudlab.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Student extends PersonRole{

    @NotEmpty(message = "Student ID is required!")
    private String studentId;

    @OneToMany(mappedBy = "student")
    private List<StudentAttendance> attendances;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<StudentAttendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<StudentAttendance> attendances) {
        this.attendances = attendances;
    }
}
