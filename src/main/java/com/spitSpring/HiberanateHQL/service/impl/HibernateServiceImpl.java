package com.spitSpring.HiberanateHQL.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spitSpring.HiberanateHQL.hibernate.dao.EmployeeDAO;
import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.service.HibernateService;

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
		return empDao.getStudents();
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		if(empDao.insertData(emp)) {
			return true;
		}
		return false;
	}


}
