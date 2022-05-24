package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	
	public Employee() {
		super();
	}
	public Employee(String fname, String lname, String email) {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="f_name",nullable=false)
	private String firstName;
	@Column(name="l_name",nullable=false)
	private String lastName;
	@Column(name="email", nullable=false)
	private String email;
	

}
