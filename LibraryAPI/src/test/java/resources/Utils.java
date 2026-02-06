package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification Reuseable() {
	
  RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://216.10.245.166").addHeader("Content-Type","application/json").build();
  
  return req;
  
	}
	
}
