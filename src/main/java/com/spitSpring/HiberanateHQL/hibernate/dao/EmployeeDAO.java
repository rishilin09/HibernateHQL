package com.spitSpring.HiberanateHQL.hibernate.dao;

import java.util.List;

import javax.swing.Spring;

import org.hibernate.*;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.hibernate.util.HibernateUtil;

@Service
public class EmployeeDAO {

	public List <Employee> getStudents() {
        try{
			SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			System.out.println(SpringVersion.getVersion());
        	List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        	return employees;
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean insertData(Employee emp) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			Employee newEmp = new Employee(emp.getEmpName(), emp.getEmpSalary(), emp.getEmpDept(), emp.getEmpAddress());
//			System.out.println(newEmp.toString());
//			session.save(newEmp);
			System.out.println(emp.toString());
			session.save(emp);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}
}
