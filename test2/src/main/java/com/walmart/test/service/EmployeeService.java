package com.walmart.test.service;

import java.util.List;

import com.walmart.test.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployes();
	
	Employee getEmployeeByID(Long id);
	
	void addEmployee(Employee employee);

}
