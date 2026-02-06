package reusableResources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	static RequestSpecification req;
	PrintStream log;

		public RequestSpecification requestSpecification()throws IOException  {
		
		if(req==null) {
		
		log = new PrintStream(new FileOutputStream("api_logs.txt"));
		req = new RequestSpecBuilder()
				.setBaseUri(globalProperties("baseUri"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON).build();
		return req;
		}
	    
	    return req;
	}
	
	
	public String globalProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream ("C:\\Users\\prati\\Learning\\Eclipse_data\\MapAPI_Cucumber\\src\\test\\java\\reusableResources\\Global.properties");
		prop.load(fi);
		return prop.getProperty(key);
	}
	
	public String getjsonpath(Response response,String key) {
		
		String jsresp=response.asString();
		JsonPath js = new JsonPath(jsresp);
		return js.getString(key);
		
	}


}
