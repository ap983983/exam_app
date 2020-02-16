package com.main.app.exam_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping(path="/")
	public String homePage() {
		return "index";
	}
	
}

