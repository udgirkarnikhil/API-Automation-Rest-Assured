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
	static RequestSpecification  Basereq;

	
	public RequestSpecification getRequestSpec() throws FileNotFoundException {
		
	
		
	if(Basereq==null) {
		PrintStream ps=new PrintStream(new FileOutputStream("APIlogs.txt"));
		Basereq=new RequestSpecBuilder()
				.setBaseUri("https://fakestoreapi.com")
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.addFilter(new RequestLoggingFilter(ps))
				.addFilter(new ResponseLoggingFilter(ps)).build();
		
		return Basereq;
		}
	return Basereq;
	}
	
}
