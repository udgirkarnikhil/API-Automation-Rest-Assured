package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class requestBuild {
	
	static RequestSpecification req;
	public static RequestSpecification getrequest() throws FileNotFoundException
	{
		
				
		if(req==null) {
		
		PrintStream fis=new PrintStream(new FileOutputStream("logs.txt"));
		req= new RequestSpecBuilder().setBaseUri("https://automationexercise.com")
		.addFilter(new RequestLoggingFilter(fis))
		.addFilter(new ResponseLoggingFilter(fis))
		.build();
		
		return req;
		}
		return req;
		
		
	}

}
