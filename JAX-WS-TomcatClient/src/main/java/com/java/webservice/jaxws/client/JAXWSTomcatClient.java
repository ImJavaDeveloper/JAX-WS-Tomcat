package com.java.webservice.jaxws.client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.java.webservice.jaxws.service.Employee;

import com.java.webservice.jaxws.service.EmployeeService;


public class JAXWSTomcatClient{
	
	public static void main(String[] args) throws MalformedURLException {
		URL wsdlURL = new URL("	http://localhost:8080/JAX-WS-ServiceProvider/employeeWS?wsdl");
		//check above URL in browser, you should see WSDL file
		
		//creating QName using targetNamespace and name
		QName qname = new QName("http://service.jaxws.webservice.java.com/", "EmployeeServiceImplService"); 
		
		Service service = Service.create(wsdlURL, qname);  
		
		//We need to pass interface and model beans to client
		EmployeeService ps = service.getPort(EmployeeService.class);
		
		Employee emp1 = new Employee(); 
		emp1.setName("Rahat");
		emp1.setEmpId(1);
		
		Employee emp2 = new Employee(); 
		emp2.setName("Rahul");
		emp2.setEmpId(2);
		
		//add Employee
		System.out.println("Add Person1 Status="+ps.addEmployee(emp1));
		System.out.println("Add Person1 Status="+ps.addEmployee(emp2));
		
		
		//get Employee
		System.out.println(ps.getEmployee(1));
		
		//get all Employee
		System.out.println(Arrays.asList(ps.getAllEmployee()));
		
		//delete Employee
		System.out.println("Delete Person Status="+ps.deleteEmployee(emp1));
		
		//get all Employee
		System.out.println(Arrays.asList(ps.getAllEmployee()));
		
	}


}
