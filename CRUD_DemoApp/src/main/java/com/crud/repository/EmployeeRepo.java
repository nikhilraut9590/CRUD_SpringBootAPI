package com.crud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crud.entity.Department;
import com.crud.entity.Employee;

@Repository
public class EmployeeRepo {
	List<Employee> empList = new ArrayList<Employee>();

	public List<Employee> getAllEmployee() {
		empList.add(new Employee(101, "Sarang", 65000.2, "pune", "sarang@gmail.com",new Department(501, "Software Engineer", "Pune")));
		empList.add(new Employee(102, "Chetan", 35600.2, "delhi", "chetan@gmail.com",new Department(502, "Software Engineer", "Pune")));
		empList.add(new Employee(103, "Shubham", 96500.2, "pune", "shubham@gmail.com",new Department(503, "Software Tester", "Delhi")));
		empList.add(new Employee(104, "Akshay", 61000.2, "mumbai", "akshay@gmail.com",new Department(504, "Manager", "Pune")));
		empList.add(new Employee(105, "Samir", 52000.2, "pune", "samir@gmail.com",new Department(505, "Software Engineer", "Nagpur")));
		empList.add(new Employee(106, "Anirudha", 165000.2, "mumbai", "anirudh@gmail.com",new Department(506, "Lead Module", "Pune")));
		empList.add(new Employee(107, "Jay", 565000.2, "indore", "jay@gmail.com",new Department(507, "Manager", "Pune")));
		return empList;

	}

	public Employee addEmployee(Employee employee) {
		if (employee != null) {
			empList.add(employee);
		}
		return employee;
	}
}
