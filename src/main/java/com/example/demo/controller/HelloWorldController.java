package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	
	@GetMapping
	String getHelloWorld(Model model) {
		String message = "HelloWorld";
		model.addAttribute("key", message);
		return "HelloWorld";
	}
}
