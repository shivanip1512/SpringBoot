package com.shivani.springboot.validation.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shivani.springboot.validation.entities.User;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("User", new User());
		return "form";
	}

	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("User") User user, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}

		System.out.println(user);
		return "success";
	}

}
