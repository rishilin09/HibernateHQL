//package com.spitSpring.HiberanateHQL.controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
//
//@RestController
//@RequestMapping(value = "/")
//public class MainController {
//
//	@GetMapping(value = "/home")
//	public ModelAndView HomePage() {
//		ModelAndView mav = new ModelAndView("Home");
//		return mav;
//	}
//	
//	@GetMapping(value = "/create")
//	public ModelAndView CreatePage() {
//		ModelAndView mav = new ModelAndView("Create");
//		mav.addObject("emp",new Employee());
//		return mav;
//	}
//	
//	@GetMapping(value = "/read")
//	public ModelAndView ReadPage() {
//		ModelAndView mav = new ModelAndView("Read");
//		return mav;
//	}
//	
//	@GetMapping(value = "/update")
//	public ModelAndView UpdatePage() {
//		ModelAndView mav = new ModelAndView("Update");
//		mav.addObject("emp",new Employee());
//		return mav;
//	}
//	
//	@GetMapping(value = "/delete")
//	public ModelAndView DeletePage() {
//		ModelAndView mav = new ModelAndView("Delete");
//		return mav;
//	}
//	
//	@GetMapping(value = "/readOne")
//	public ModelAndView ReadOnePage() {
//		ModelAndView mav = new ModelAndView("ReadOne");
//		return mav;
//	}
//	
//	
//}
