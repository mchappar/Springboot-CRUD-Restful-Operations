package com.springboot.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.EmployeeRepository;
import com.springboot.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository empRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee emp)
	{
		return empRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepository.findAll();
	}
	
	
	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> emp = empRepository.findById(id);
		if( emp.isPresent())
		{
			return emp.get();
		}
		else 
		{
			throw new ResourceNotFoundException("Employee","ID","id");
		}
	}
		 
	
	

	@Override
	public Employee updateEmployee(Employee emp, long id) {
		//check if emp with given ID is existing in DB
		Employee existingEmp = empRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		existingEmp.setFirstName(emp.getFirstName());
		existingEmp.setLastName(emp.getLastName());
		existingEmp.setEmail(emp.getEmail());
		empRepository.save(existingEmp);
		return existingEmp;	
	}
	
	@Override
	public void deleteEmployee(long id)
	{
		//check if emp with given ID is existing in DB
		empRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		empRepository.deleteById(id);
	}

	
	
	
}
