package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.addEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		getAllEmployee().removeIf(x -> x.getEmpid().equals(empId));

	}

	@Override
	public Employee updateEmployeeById(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {

		Employee getEmp = getAllEmployee().stream().filter(emp -> emp.getEmpid() == empId).findFirst().orElse(null);
		return getEmp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.getAllEmployee();
	}

}
