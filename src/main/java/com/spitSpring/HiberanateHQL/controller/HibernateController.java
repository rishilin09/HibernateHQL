package com.spitSpring.HiberanateHQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.service.HibernateService;

@RestController
@RequestMapping(value = "/")
public class HibernateController {
	
	@Autowired
	private HibernateService hibServ;

	public HibernateController(HibernateService hibServ) {
		super();
		this.hibServ = hibServ;
	}
	
	@GetMapping(value = "/home")
	public ModelAndView HomePage() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	@GetMapping(value = "/create")
	public ModelAndView CreatePage() {
		ModelAndView mav = new ModelAndView("Create");
		mav.addObject("emp",new Employee());
		return mav;
	}
	
	@PostMapping(value = "/create")
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		ModelAndView mav = new ModelAndView("Create");
		if(hibServ.insertEmployee(emp)){
			mav.addObject("result","Data successfully stored!!");
		} else {
			mav.addObject("result","Error in uploading the data!!");
		}
		return mav;
	}
	
	@GetMapping(value = "/read")
	public ModelAndView ReadPage() {
		ModelAndView mav = new ModelAndView("Read");
		return mav;
	}
	
	@GetMapping(value = "/update")
	public ModelAndView UpdatePage() {
		ModelAndView mav = new ModelAndView("Update");
		mav.addObject("emp",new Employee());
		return mav;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView DeletePage() {
		ModelAndView mav = new ModelAndView("Delete");
		return mav;
	}
	
	@GetMapping(value = "/readOne")
	public ModelAndView ReadOnePage() {
		ModelAndView mav = new ModelAndView("ReadOne");
		return mav;
	}
	
	@GetMapping(value = "/fetch")
	public Object fetchAllEmployees() {
		List<Employee> employees = hibServ.getAllEmployees();
		if(employees != null) {
			return employees;
		} else {
			return "Cannot fetch the data!!!";
		}
	}

//	@PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
	
	
	@PostMapping(value = "/fetchByID")
	public Object getEmployeeById(@RequestParam(name = "id") String Id) {
		Employee getEmp = hibServ.getEmployeebyId(Id);
		if(getEmp != null){
			return getEmp;
		} else {
			return "No Data Found with this ID!!";
		}
	}
	
	@PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object getEmployeeById(@RequestBody Employee emp) {
		if(hibServ.updateEmployee(emp)){
			return "DATA GOT UPDATED SUCCESSFULLY!!";
		} else {
			return "DATA DIDN'T GOT UPDATED!!";
		}
	}
	
	@DeleteMapping(value = "/deleteById")
	public Object deleteEmployeeById(@RequestParam(name = "id") String Id) {
		if(hibServ.deleteEmployeebyId(Id)){
			return "DATA GOT DELETED SUCCESSFULLY!!!";
		} else {
			return "DATA DIDN'T GOT DELETED!!";
		}
	}
}
