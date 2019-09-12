package com.java.webservice.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.java.webservice.jaxws.beans.Employee;

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface EmployeeService {
	
	@WebMethod
	public boolean addEmployee(Employee e);
	
	@WebMethod
	public boolean deleteEmployee(Employee e);
	
	@WebMethod
	public Employee getEmployee(int empId);
	
	@WebMethod
	public Employee[] getAllEmployee();
	

}
