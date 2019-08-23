package com.crud.service;

import java.util.List;

import com.crud.entity.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);

	void deleteEmployeeById(Integer empId);

	Employee updateEmployeeById(Employee employee);

	Employee getEmployeeById(Integer empId);

	List<Employee> getAllEmployee();

}
