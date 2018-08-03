package edu.mum.cs.cs425swe.crudlab.controller;

import edu.mum.cs.cs425swe.crudlab.model.Course;
import edu.mum.cs.cs425swe.crudlab.service.CourseService;
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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/crudlab/courses", method = RequestMethod.GET)
    public ModelAndView courses() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("courses", courseService.findAll("cod"));
        mav.setViewName("course/list");
        return mav;
    }

    @RequestMapping(value = "/crudlab/course/new", method = RequestMethod.GET)
    public String courseRegistrationPage(Model model) {
        model.addAttribute("newCourse", new Course());
        return "course/new";
    }

    @RequestMapping(value = "/crudlab/course/new", method = RequestMethod.POST)
    public String registerNewCourse(@Valid @ModelAttribute("newCourse") Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "course/new";
        }
        course = courseService.save(course);
        return "redirect:/crudlab/courses";
    }

    @RequestMapping(value = "/crudlab/course/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        courseService.deleteById(id);
        return "redirect:/crudlab/courses";
    }

    @RequestMapping(value = "/crudlab/course/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewCourseInformation(@PathVariable Long id, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("courseView", courseService.findById(id));
        mav.setViewName("course/view");
        return mav;
    }

    @RequestMapping(value = "/crudlab/course/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCourseInformationPage(@PathVariable Long id, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("editingCourse", courseService.findById(id));
        mav.setViewName("course/edit");
        return mav;
    }

    @RequestMapping(value = "/crudlab/course/edit", method = RequestMethod.POST)
    public String editCourseInformation(@Valid @ModelAttribute("editingCourse") Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "course/edit";
        }
        course = courseService.save(course);
        return "redirect:/crudlab/courses";
    }

}
