package com.springboot.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Employee;
import com.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employeeREST")
public class EmployeeController {
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	//build create employee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		
		System.out.println("Hiiiiii");
		return new ResponseEntity<Employee>(empService.saveEmployee(emp),HttpStatus.CREATED);
		
	}
	
	//build GET all employees REST API
	//http://localhost:8080/api/employ/
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	
	
	//build GET Employee by ID REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(empService.getEmployeeByID(id),HttpStatus.OK);
	}
	
	
	
	
	//build Update employee REST API 
	//http://localhost:8080/api/employ/1
	//curly braces are used bcos path variables here can be dynamically changed
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empService.updateEmployee(emp, id),HttpStatus.OK);
	}

	
	// build Delete employee REST API 
	//http://localhost:8080/api/employ/1
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		empService.deleteEmployee(id);
		return new ResponseEntity<String>( "Employee Deleted Successfully!! ",HttpStatus.OK);
	}
	
}

	