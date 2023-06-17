package com.spitSpring.HiberanateHQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/* Home page with 5 buttons (Create, Read-All, Update, Read-One, Delete) */	
	@GetMapping(value = {"/","/home"})
	public ModelAndView HomePage() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	/* To insert data into the table */	
	@GetMapping(value = "/create")
	public ModelAndView CreatePage() {
		ModelAndView mav = new ModelAndView("Create");
		mav.addObject("emp",new Employee());
		mav.addObject("result","");
		return mav;
	}
	
	
	@PostMapping(value = "/create")
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		ModelAndView mav = new ModelAndView("Create");
		mav.addObject("emp",new Employee());
		if(hibServ.insertEmployee(emp)){
			mav.addObject("result","Data successfully stored!!");
		} else {
			mav.addObject("result","Error in uploading the data!!");
		}
		return mav;
	}
	
	
	/* To fetch all the data from the table */	
	@GetMapping(value = "/read")
	public ModelAndView ReadPage() {
		ModelAndView mav = new ModelAndView("Read");
		List<Employee> employees = hibServ.getAllEmployees();
		if(employees != null) {
			mav.addObject("emp",employees);
		} else {
			mav.addObject("error","No Data to get list down!!");
		}
		return mav;
	}
	
	
	/* To update a particular data in the table using empID column*/	
	@GetMapping(value = "/update")
	public ModelAndView UpdatePage() {
		ModelAndView mav = new ModelAndView("Update");
		mav.addObject("emp",new Employee());
		mav.addObject("result", "");
		mav.addObject("error","");
		return mav;
	}
	
	
	@PostMapping(value = "/update")
	public ModelAndView UpdateForm(@ModelAttribute Employee emp) {
		ModelAndView mav = new ModelAndView("Update");
		emp = hibServ.getEmployeebyId(emp.getEmpId());
		if(emp != null){
			mav.addObject("emp", emp);
			mav.addObject("result","");
			mav.addObject("error","");
		} else {
			mav.addObject("emp",new Employee());
			mav.addObject("result","");
			mav.addObject("error","No Data Found with this ID!!");
		}
		return mav;
	}
	
	
	@PostMapping(value = "/updateForm")
	public ModelAndView UpdateSuccess(@ModelAttribute Employee emp) {
		System.out.println(emp.toString());
		ModelAndView mav = new ModelAndView("Update");
		boolean isUpdated = hibServ.updateEmployee(emp);
		if(isUpdated){
			mav.addObject("result","DATA GOT UPDATED SUCCESSFULLY!!");
			mav.addObject("error","");
		} else {
			mav.addObject("result","");
			mav.addObject("error","DATA DIDN'T GOT UPDATED!!");
		}
		mav.addObject("emp",new Employee());
		return mav;
	}
	
	/* To fetch single data from the table using empId column */	
	@GetMapping(value = "/fetchByID")
	public ModelAndView ReadOnePage() {
		ModelAndView mav = new ModelAndView("ReadOne");
		mav.addObject("emp",new Employee());
		return mav;
	}
	
	@PostMapping(value = "/fetchByID")
	public ModelAndView getEmployeeById(@ModelAttribute Employee emp) {
		Employee getEmp = hibServ.getEmployeebyId(emp.getEmpId());
		ModelAndView mav = new ModelAndView("ReadOne");
		if(getEmp != null){
			mav.addObject("emp",getEmp);
			mav.addObject("result","");
		} else {
			mav.addObject("emp",new Employee());
			mav.addObject("result","No Data Found with this ID!!");
		}
		return mav;
	}
	
	/* To delete a particular data from the table using empId column */
	@GetMapping(value = "/deleteById")
	public ModelAndView DeletePage() {
		ModelAndView mav = new ModelAndView("Delete");
		mav.addObject("emp",new Employee());
		mav.addObject("result","");
		return mav;
	}
	
	@PostMapping(value = "/deleteById")
	public ModelAndView deleteEmployeeById(@ModelAttribute Employee emp) {
		ModelAndView mav = new ModelAndView("Delete");
		mav.addObject("emp",new Employee());
		if(hibServ.deleteEmployeebyId(emp.getEmpId())){
			mav.addObject("result","DATA GOT DELETED SUCCESSFULLY!!!");
		} else {
			mav.addObject("result","DATA DIDN'T GOT DELETED!!");
		}
		return mav;
	}
}

