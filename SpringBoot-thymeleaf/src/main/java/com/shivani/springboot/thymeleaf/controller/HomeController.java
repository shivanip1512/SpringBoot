package com.shivani.springboot.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String baseHandler() {
		return "profile";
	}
	
	@GetMapping("/contact")
	public String contactHandler() {
		return "contact";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("inside home handler");
		model.addAttribute("name", "Shivani");
		model.addAttribute("currentDate", new Date().toString());
		return "home";
	}

	@GetMapping(value = "/iterator")
	public String iterateHandler(Model model) {
		List<String> friends = List.of("Shivani", "Sweety", "Kirti");
		model.addAttribute("friends", friends);
		return "iterate";
	}

	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		model.addAttribute("isActive", false);
		model.addAttribute("gender", "M");

		List<Integer> list = List.of(1, 2, 3, 4);
		model.addAttribute("mylist", list);
		return "conditional";
	}

	@GetMapping("/service")
	public String serviceHandler(Model model) {
		model.addAttribute("msg1", "This is Message1 from Controller");
		model.addAttribute("date", LocalDateTime.now());
		return "service";
	}

}
