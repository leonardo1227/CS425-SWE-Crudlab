package edu.mum.cs.cs425swe.crudlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/crudlab/home", method = RequestMethod.GET)
    public String homePage(){
        return "index";
    }
}
