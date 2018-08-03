package edu.mum.cs.cs425swe.crudlab.controller;

import edu.mum.cs.cs425swe.crudlab.model.Student;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/crudlab/students", method = RequestMethod.GET)
    public ModelAndView students(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", studentService.findAll("person.firstName"));
        mav.setViewName("student/list");
        return mav;
    }

    @RequestMapping(path = "/crudlab/student/new", method = RequestMethod.GET)
    public String studentRegistrationPage(Model model){
        model.addAttribute("newStudent", new Student());
        return "student/new";
    }

    @RequestMapping(path = "/crudlab/student/new", method = RequestMethod.POST)
    public String registerNewStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.save(student);
        return "redirect:/crudlab/students";
    }

    @RequestMapping(path = "/crudlab/student/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        studentService.deleteById(id);
        return "redirect:/crudlab/students";
    }

    @RequestMapping(path = "/crudlab/student/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewStudentInformation(@PathVariable Long id, Model model){
        ModelAndView mav = new ModelAndView();
        mav.addObject("viewingStudent", studentService.findById(id));
        mav.setViewName("student/view");
        return mav;
    }

    @RequestMapping(path = "/crudlab/student/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editStudentInformationPage(@PathVariable Long id, Model model){
        ModelAndView mav = new ModelAndView();
        mav.addObject("editingStudent", studentService.findById(id));
        mav.setViewName("/student/edit");
        return mav;
    }

    @RequestMapping(path = "/crudlab/student/edit", method = RequestMethod.POST)
    public String editStudentInformation(@Valid @ModelAttribute("editingStudent") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.save(student);
        return "redirect:/crudlab/students";
    }
}
