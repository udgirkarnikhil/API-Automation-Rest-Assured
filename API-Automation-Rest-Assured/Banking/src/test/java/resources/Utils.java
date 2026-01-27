package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public RequestSpecification getRequestSpecification() throws FileNotFoundException
	{
		PrintStream ps=new PrintStream(new FileOutputStream("APIlog.txt"));
		
		RequestSpecification basereq=new RequestSpecBuilder()
				.setBaseUri("https://demo.testfire.net/api")
				.addFilter(new RequestLoggingFilter(ps))
				.addFilter(new ResponseLoggingFilter(ps))
				.setContentType(ContentType.JSON).build();
		
		return basereq;
		
	}

}
