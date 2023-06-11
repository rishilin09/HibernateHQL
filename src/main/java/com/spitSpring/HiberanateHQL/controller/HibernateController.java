package com.spitSpring.HiberanateHQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping(value = {"/","/home"})
	public ModelAndView HomePage() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
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
	
	@GetMapping(value = "/update")
	public ModelAndView UpdatePage() {
		ModelAndView mav = new ModelAndView("Update");
		mav.addObject("emp",new Employee());
		return mav;
	}
	
	@GetMapping(value = "/deleteById")
	public ModelAndView DeletePage() {
		ModelAndView mav = new ModelAndView("Delete");
		mav.addObject("emp",new Employee());
		mav.addObject("result","");
		return mav;
	}
	
	@GetMapping(value = "/fetchByID")
	public ModelAndView ReadOnePage() {
		ModelAndView mav = new ModelAndView("ReadOne");
		mav.addObject("emp",new Employee());
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
	
	@PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object updateEmployeeById(@RequestBody Employee emp) {
		if(hibServ.updateEmployee(emp)){
			return "DATA GOT UPDATED SUCCESSFULLY!!";
		} else {
			return "DATA DIDN'T GOT UPDATED!!";
		}
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
	
//	@DeleteMapping(value = "/deleteById")
//	public Object deleteEmployeeById(@RequestParam(name = "id") String Id) {
//		if(hibServ.deleteEmployeebyId(Id)){
//			return "DATA GOT DELETED SUCCESSFULLY!!!";
//		} else {
//			return "DATA DIDN'T GOT DELETED!!";
//		}
//	}
}


//@GetMapping(value = "/readOne")
//public ModelAndView readOnePage(Model model) {
//    ModelAndView mav = new ModelAndView("ReadOne");
//    mav.addObject("oneemp", new Employee());
//    return mav;
//}
//
//@PostMapping(value = "/readOne")
//public ModelAndView getReadOnePage(@RequestParam(name = "id") String id, Model model) {
//    Employee retrievedEmployee = hibServ.getEmployeebyId(id);
//    model.addAttribute("oneemp", retrievedEmployee);
//    ModelAndView mav = new ModelAndView("ReadOne");
//    mav.addObject("id", id);
//    return mav;
//}

