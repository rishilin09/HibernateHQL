package com.spitSpring.HiberanateHQL.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spitSpring.HiberanateHQL.hibernate.dao.EmployeeDAO;
import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.service.HibernateService;


/* Class having Implementation of Hibernate Services */

@Service
public class HibernateServiceImpl implements HibernateService{
	
	@Autowired
	private EmployeeDAO empDao;
	
	public HibernateServiceImpl(EmployeeDAO empDao) {
		super();
		this.empDao = empDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empDao.getEmployees();
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		if(empDao.insertEmployeeData(emp)) {
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployeebyId(String Id) {
		return empDao.getEmployeeById(Id);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		if (empDao.updateEmployeeById(emp)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployeebyId(String empId) {
		if (empDao.deleteEmployeeByID(empId)) {
			return true;
		}
		return false;
	}


}
