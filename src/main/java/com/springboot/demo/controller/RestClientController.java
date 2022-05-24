package com.springboot.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.demo.model.Employee;
  
public class RestClientController {
	
	private static final String GET_ALL_EMP_API ="http://localhost:8080/api/employeeREST";
	private static final String GET_EMP_BY_ID ="http://localhost:8080/api/employeeREST/{id}";
	private static final String CREATE_ALL_EMP_API ="http://localhost:8080/api/employeeREST";
	private static final String UPDATE_EMP_API ="http://localhost:8080/api/employeeREST/{id}";
	private static final String DELETE_EMP_API ="http://localhost:8080/api/employeeREST/{id}";
	
	static RestTemplate restTemp = new RestTemplate();
	public static void main(String Args[]) {
		//callGetEmpAPI();
		callGetEmpByIDAPI();  
	  // callCreateEmpAPI();
		//callUpdateEmpAPI();
		//callDeleteEmpAPI();
		
	}


private static void callGetEmpAPI()
{
	
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<String> entity =  new HttpEntity<>("parameters",headers);
	ResponseEntity<String> result = restTemp.exchange(GET_ALL_EMP_API , HttpMethod.GET, entity, String.class);
	System.out.println(result);
}

private static void callGetEmpByIDAPI()
{
	Map<String,Integer> param =new HashMap<>();
	param.put("id", 1);
	Employee result = restTemp.getForObject(GET_EMP_BY_ID, Employee.class, param);
	System.out.println(result.getFirstName());
	System.out.println(result.getLastName());
	System.out.println(result.getEmail());
}


/*private static void callCreateEmpAPI() {
	Employee emp = new Employee("Supriya","Pandit","sup@gmail.com");
	ResponseEntity<Employee> result = restTemp.postForEntity(CREATE_ALL_EMP_API, emp, Employee.class);
	System.out.println(result.getBody());
}*/

private static void callCreateEmpAPI() {
HttpEntity<Employee> entity = new HttpEntity<>(new Employee("Supriya","Pandit","sup@gmail.com"));
String result = restTemp.postForObject(CREATE_ALL_EMP_API, entity, String.class);
System.out.println(result);
}



private static void callUpdateEmpAPI() {
	
	Map<String, Integer> param = new HashMap<>();
	param.put("id", 2);
	Employee updateEmp = new Employee("priya", "Samant","priya@gmail.com");	
	restTemp.put(UPDATE_EMP_API, updateEmp, param);

}


private static void callDeleteEmpAPI() {
	Map<String, Integer> param = new HashMap<>();
	param.put("id", 5);
	restTemp.delete(DELETE_EMP_API, param);
}

}