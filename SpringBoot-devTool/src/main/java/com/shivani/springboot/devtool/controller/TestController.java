package com.shivani.springboot.devtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a = 45;
		int b = 50;
		int c = 50;
		return "this is test controller \n sum of " + a + ", " + b + " and " + c + " is " + (a + b + c);
	}
}
