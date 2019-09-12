package com.java.webservice.jaxws.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.ws.Endpoint;

import com.java.webservice.jaxws.service.EmployeeServiceImpl;

public class SOAPPublisher extends Thread {
	
	
	private static final int BUFFER_SIZE = 4096;
	static HttpURLConnection connection;
	static URL url;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("URL: "+UtilsConstant.URL);
		System.out.println("WSDL: "+UtilsConstant.URL+"?wsdl" );
		if(isServicePublished())
		System.out.println("Service Is Published Now");
		else
		{
			System.out.println("Service Is Not Published");
		}
		
		//System.exit(0);
}

	public static boolean isServicePublished() throws IOException 
	{
		
		int code=404;
		
			try {
				url = new URL(UtilsConstant.URL);
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				code = connection.getResponseCode();
				System.out.println(connection.getContent().getClass());
				connection.disconnect();
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("MalformedURLException");
				e.printStackTrace();
			}	
			catch (ProtocolException e) {
				System.out.println("ProtocolException....");
				e.printStackTrace();
			}
			 catch (IOException e) {
				 System.out.println("URL was not accessible");
				//e.printStackTrace();
				 if(e.toString().contains("Connection refused"))
				 {
					    System.out.println("Publishing Service....");
						Endpoint.publish(UtilsConstant.URL, UtilsConstant.service);
						url = new URL(UtilsConstant.URL+"?wsdl");		
						connection=(HttpURLConnection) url.openConnection();
						connection.setRequestMethod("GET");
						code = connection.getResponseCode();
						saveWSDL(connection,UtilsConstant.WSDLFilePath,UtilsConstant.WSDLFileName);
						code=200;
						
						
				 }
					 
			}
						
		if(code==200)
		{
		
		return true;
		}else
		{
			return false;
		}
		
	}
	
	public static void saveWSDL(HttpURLConnection connection,String saveFilePath,String WSDLName) throws IOException
	{
		InputStream inputStream = connection.getInputStream();
		File directory = new File(saveFilePath);	    
		
		if(!directory.exists())
		directory.mkdirs();
	    String WSDLFileName=saveFilePath+"/"+WSDLName ;	    
	    System.out.println("File:"+WSDLFileName);
		
		
	    FileOutputStream outputStream = new FileOutputStream((WSDLFileName) );		
		int bytesRead = -1;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();

        System.out.println("WSDL File Saved");
    
	
}
}