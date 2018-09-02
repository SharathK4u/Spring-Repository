package com.skdamoda.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skdamoda.mvc.bean.Person;

@Controller
public class PersonController {
	
	@RequestMapping("/add")
	public ModelAndView addPerson() {
		System.out.println("Add Person");
		return new ModelAndView("personForm","person",new Person());
	}
	
	@RequestMapping("/save")
	public ModelAndView savePerson(@ModelAttribute("person") Person person) {
		System.out.println(person);
		return new ModelAndView("viewForm","person",person);
	}
	
}
