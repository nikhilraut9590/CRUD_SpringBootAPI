package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("employee/")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empId) {
		Employee employee = empService.getEmployeeById(empId);
		if (employee == null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee Deleted succesfully!", HttpStatus.OK);
	}
}
