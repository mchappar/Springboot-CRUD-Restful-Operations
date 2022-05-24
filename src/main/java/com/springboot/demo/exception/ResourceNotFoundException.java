package com.springboot.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	//object type is used as fieldvalue can be of any type
	private Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("'%s not  found with %s '%s'  '", resourceName, fieldName , fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
		
	}
	
	public String getFieldName() {
		return resourceName;
		
	}
	
	public String getFieldValue() {
		return resourceName;
		
	}
	
	
	

}
