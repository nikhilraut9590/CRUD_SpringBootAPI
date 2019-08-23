package com.crud.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.entity.Department;
import com.crud.entity.Employee;

public class EmployeeServiceTest {
	@Autowired
	MovieService movieService;
	
	@Test
	public void testGetEmployeeById() {
		/*
		 * EmployeeService employeeServiceMock = mock(EmployeeServiceImpl.class);
		 * when(employeeServiceMock.getEmployeeById(1)).thenReturn( new Employee(1,
		 * "abc", 352.0, "pune", "nik@gmail.com", new Department(201, "soft eng",
		 * "pune")));
		 */
		System.out.println(movieService);
		
	}
	
	
	
}
