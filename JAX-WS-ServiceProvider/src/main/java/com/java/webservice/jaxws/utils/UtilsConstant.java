package com.java.webservice.jaxws.utils;

import com.java.webservice.jaxws.service.EmployeeServiceImpl;

public class UtilsConstant {
	
	public static final String URL="http://localhost:8888/ws/employeeWS";
	public static final Object service=new EmployeeServiceImpl(); 
	public static final String WSDLFilePath="client/wsdl/";
	public static final String WSDLFileName="EmployeeServiceImpl.wsdl";

}
