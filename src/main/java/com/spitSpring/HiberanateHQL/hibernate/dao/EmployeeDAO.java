package com.spitSpring.HiberanateHQL.hibernate.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.spitSpring.HiberanateHQL.hibernate.entity.Employee;
import com.spitSpring.HiberanateHQL.hibernate.util.HibernateUtil;

@Service
public class EmployeeDAO {

	public List<Employee> getStudents() {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			String queryStr = "FROM Employee";
			List<Employee> employees = session.createQuery(queryStr, Employee.class).list();
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
			System.out.println(emp.toString());
			@SuppressWarnings("deprecation")
			Long result = (Long) session.save(emp);
			System.out.println(result);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				return false;
			}
			throw new RuntimeException(e);
		}
	}

	public Employee getEmployeeById(String empId) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String queryStr = "FROM Employee E where E.empId = :employee_Id";
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Employee> query = session.createQuery(queryStr);
			query.setParameter("employee_Id", empId);
			Employee getEmp = query.uniqueResult();
			transaction.commit();
			return getEmp;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}

	public boolean updateEmployee(Employee emp) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String queryStr = "UPDATE Employee E SET E.empSalary = :Salary, E.empAddress = :Address, E.empDept = :Dept, E.empName = :Name " 
					+ "WHERE E.empId = :employee_Id";
			System.out.println(emp);
			@SuppressWarnings({ "deprecation", "unchecked" })
			Query<Employee> query = session.createQuery(queryStr);
			query.setParameter("Salary", emp.getEmpSalary());
			query.setParameter("Address", emp.getEmpAddress());
			query.setParameter("Name", emp.getEmpName());
			query.setParameter("Dept", emp.getEmpDept());
			query.setParameter("employee_Id", emp.getEmpId());
			int result = query.executeUpdate();
			System.out.println(result);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				return false;
			}
			throw new RuntimeException(e);
		}
	}

}
