package edu.mum.cs.cs425swe.crudlab.controller;

import edu.mum.cs.cs425swe.crudlab.model.StudentAttendance;
import edu.mum.cs.cs425swe.crudlab.service.CourseOfferService;
import edu.mum.cs.cs425swe.crudlab.service.StudentAttendanceService;
import edu.mum.cs.cs425swe.crudlab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentCourseAssignmentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentAttendanceService studentAttendanceService;
    @Autowired
    private CourseOfferService courseOfferService;

    @RequestMapping(path = "/crudlab/student-course-assignament/new/{studentId}", method = RequestMethod.GET)
    public ModelAndView studentCourseAssignamentClass(@PathVariable Long studentId, Model model) {
        ModelAndView mav = new ModelAndView();
        StudentAttendance studentAttendance = new StudentAttendance();
        studentAttendance.setStudent(studentService.findById(studentId));
        mav.addObject("newStudentAttendance", studentAttendance);
        mav.addObject("courseOffers", courseOfferService.findAll("course.cod"));
        mav.setViewName("student-course-assignament/new");
        return mav;
    }

    @RequestMapping(path = "/crudlab/student-class-assginament/new", method = RequestMethod.POST)
    public String assignamentCourseToStudent(@Valid @ModelAttribute("newStudentAttendance")StudentAttendance studentAttendance, BindingResult bindingResult, Model model){

        studentAttendance.setCourseOffer(courseOfferService.findById(studentAttendance.getCourseOffer().getId()));//
        studentAttendance.setStudent(studentService.findById(studentAttendance.getStudent().getId()));

        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "student-course-assignament/new";
        }
        studentAttendance = studentAttendanceService.save(studentAttendance);
        return "redirect:/crudlab/student/view/"+studentAttendance.getStudent().getId();
    }




}
