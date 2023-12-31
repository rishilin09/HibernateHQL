package com.spitSpring.HiberanateHQL.service;

import java.util.List;

import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;


/* Interface for the Hibernate Services */

public interface HibernateService {

	public List<Employee> getAllEmployees();

	public boolean insertEmployee(Employee emp);
	
	public Employee getEmployeebyId(String Id);
	
	public boolean updateEmployee(Employee emp);
	
	public boolean deleteEmployeebyId(String empId);

}
