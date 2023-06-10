//package com.spitSpring.HiberanateHQL.hibernate.entity;
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "employee")
//public class Employee {
//	
//
//	public Employee() {}
//	
//	public Employee(String empName, long empSalary, String empDept, String empAddress) {
//		super();
//		this.empName = empName;
//		this.empSalary = empSalary;
//		this.empDept = empDept;
//		this.empAddress = empAddress;
//	}
//	
//	@Id
//	@Access(AccessType.FIELD)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "empId")
//	public Long empId;
//	
//	public Long getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(Long empId) {
//		this.empId = empId;
//	}
//	
//	
//	@Column(name = "empName")
//	private String empName;
//	
//	public String getEmpName() {
//		return empName;
//	}
//
//	public void setEmpName(String empName) {
//		this.empName = empName;
//	}
//	
//	@Column(name = "empSalary")
//	private long empSalary;
//	
//	public long getEmpSalary() {
//		return empSalary;
//	}
//
//	public void setEmpSalary(long empSalary) {
//		this.empSalary = empSalary;
//	}
//
//	@Column(name = "empDept")
//	private String empDept;
//	
//	public String getEmpDept() {
//		return empDept;
//	}
//
//	public void setEmpDept(String empDept) {
//		this.empDept = empDept;
//	}
//	
//	@Column(name = "empAddress")
//	private String empAddress;
//	
//	public String getEmpAddress() {
//		return empAddress;
//	}
//
//	public void setEmpAddress(String empAddress) {
//		this.empAddress = empAddress;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary
//				+ ", empDept=" + empDept + ", empAddress=" + empAddress + "]";
//	}
//}
package com.spitSpring.HiberanateHQL.hibernate.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	

	public Employee() {}
	
	public Employee(String empName, long empSalary, String empDept, String empAddress) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDept = empDept;
		this.empAddress = empAddress;
	}
	
	@Id
	@Access(AccessType.FIELD)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empId")
	public Long empId;
	
	@Column(name = "empName")
	public String empName;
	
	@Column(name = "empSalary")
	public long empSalary;
	
	@Column(name = "empDept")
	public String empDept;
	
	@Column(name = "empAddress")
	public String empAddress;
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", empDept=" + empDept + ", empAddress=" + empAddress + "]";
	}
}
