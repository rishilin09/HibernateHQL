package com.spitSpring.HiberanateHQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.service.HibernateService;

@RestController
@RequestMapping(value = "/home/methods")
public class HibernateController {
	
	@Autowired
	private HibernateService hibServ;

	public HibernateController(HibernateService hibServ) {
		super();
		this.hibServ = hibServ;
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

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmployee(@RequestBody Employee emp) {
		if(hibServ.insertEmployee(emp)){
			return "Data successfully stored!!";
		} else {
			return "Error in uploading the data";
		}
	}
	
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
