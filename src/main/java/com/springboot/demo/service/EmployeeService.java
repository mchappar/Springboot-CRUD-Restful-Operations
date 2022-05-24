package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeByID(long id);
	Employee updateEmployee(Employee emp,long id);
	void deleteEmployee(long id);
}
