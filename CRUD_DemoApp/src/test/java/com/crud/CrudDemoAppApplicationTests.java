package com.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crud.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudDemoAppApplicationTests {

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
