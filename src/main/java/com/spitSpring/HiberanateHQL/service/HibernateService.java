package com.spitSpring.HiberanateHQL.service;

import java.util.List;

import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;

public interface HibernateService {

	public List<Employee> getAllEmployees();

	public boolean insertEmployee(Employee emp);

}
