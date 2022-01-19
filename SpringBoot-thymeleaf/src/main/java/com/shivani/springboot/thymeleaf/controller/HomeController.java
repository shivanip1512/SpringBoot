package com.shivani.springboot.thymeleaf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value =  "/",method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("inside home handler");
		model.addAttribute("name","Shivani");
		model.addAttribute("currentDate",new Date().toString());
		return "home";
	}

	@GetMapping(value = "/iterator")
	public String iterateHandler(Model model) {
		List<String> friends = List.of("Shivani","Sweety","Kirti");
		model.addAttribute("friends",friends);
		return "iterate";
	}
	
}
