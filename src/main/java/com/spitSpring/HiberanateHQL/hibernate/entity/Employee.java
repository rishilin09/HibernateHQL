package com.spitSpring.HiberanateHQL.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	

	public Employee() {}
	
	public Employee(String empId,String empName, long empSalary, String empDept, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDept = empDept;
		this.empAddress = empAddress;
	}
	
	
	private Long Srno;
	
	
	private String empId;
	
	
	private long empSalary;
	
	
	private String empName;
	
	
	private String empDept;
	
	
	private String empAddress;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Srno")
	public Long getSrno() {
		return Srno;
	}

	public void setSrno(Long Srno) {
		this.Srno = Srno;
	}
	
	
	@Column(name = "empId")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	@Column(name = "empName")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	@Column(name = "empSalary")
	public long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	
	@Column(name = "empDept")
	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	
	@Column(name = "empAddress")
	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", empDept=" + empDept + ", empAddress=" + empAddress + "]";
	}
}
