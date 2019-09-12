package com.java.webservice.jaxws.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.java.webservice.jaxws.beans.Employee;

@WebService(endpointInterface="com.java.webservice.jaxws.service.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Integer,Employee> employee=new HashMap<Integer,Employee>();
	
	@Override
	public boolean addEmployee(Employee e) {
		
		if(employee.get(e.getEmpId())!=null)
			return false;
		else
		{
			employee.put(e.getEmpId(), e);
		return true;
		}
		
		
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		
		if(employee.get(e.getEmpId())!=null)
			return false;
		else
		{
			employee.remove(e.getEmpId());
			return true;
		}
		
		
	}

	@Override
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return employee.get(empId);
	}

	@Override
	public Employee[] getAllEmployee() {
		// TODO Auto-generated method stub
		Set<Integer> ids=employee.keySet();
		Employee [] emps=new Employee[ids.size()];
		int i=0;
		for(Integer id:ids)
		{
			emps[i]=employee.get(id);
			i++;
		}
			
		return emps;
	}

}
