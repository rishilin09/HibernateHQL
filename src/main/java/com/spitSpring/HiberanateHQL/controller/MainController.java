package com.spitSpring.HiberanateHQL.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class MainController {

	@GetMapping(value = "/home")
	public ModelAndView HomePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
}
