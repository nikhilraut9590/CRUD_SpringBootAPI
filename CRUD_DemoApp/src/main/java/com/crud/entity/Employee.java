package com.crud.entity;

public class Employee {
	private Integer empid;
	private String empName;
	private double salary;
	private String city;
	private String email;
	private Department department;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer empid, String empName, double salary, String city, String email, Department department) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.salary = salary;
		this.city = city;
		this.email = email;
		this.department = department;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
