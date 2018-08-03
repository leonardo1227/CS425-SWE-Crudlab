package edu.mum.cs.cs425swe.crudlab.controller;

import edu.mum.cs.cs425swe.crudlab.model.Faculty;
import edu.mum.cs.cs425swe.crudlab.service.FacultyService;
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
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(path = "/crudlab/faculties", method = RequestMethod.GET)
    public ModelAndView faculties() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("faculties", facultyService.findAll("person.firstName"));
        mav.setViewName("faculty/list");
        return mav;
    }

    @RequestMapping(path = "/crudlab/faculty/new", method = RequestMethod.GET)
    public String facultyRegistrationPage(Model model) {
        model.addAttribute("newFaculty", new Faculty());
        return "faculty/new";
    }

    @RequestMapping(path = "/crudlab/faculty/new", method = RequestMethod.POST)
    public String registerNewFaculty(@Valid @ModelAttribute("newFaculty") Faculty faculty, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "faculty/new";
        }
        faculty = facultyService.save(faculty);
        return "redirect:/crudlab/faculties";
    }

    @RequestMapping(path = "/crudlab/faculty/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        facultyService.deleteById(id);
        return "redirect:/crudlab/faculties";
    }

    @RequestMapping(path = "/crudlab/faculty/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewFacultyInformation(@PathVariable Long id, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("viewingFaculty", facultyService.findById(id));
        mav.setViewName("faculty/view");
        return mav;
    }

    @RequestMapping(path = "/crudlab/faculty/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editFacultyInformationPage(@PathVariable Long id, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("editingFaculty", facultyService.findById(id));
        mav.setViewName("/faculty/edit");
        return mav;
    }

    @RequestMapping(path = "/crudlab/faculty/edit", method = RequestMethod.POST)
    public String editFacultyInformation(@Valid @ModelAttribute("editingFaculty") Faculty faculty, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "faculty/edit";
        }
        faculty = facultyService.save(faculty);
        return "redirect:/crudlab/faculties";
    }
}
