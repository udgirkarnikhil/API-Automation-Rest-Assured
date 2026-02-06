package resources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification ReqSpec() {
		
		
       RequestSpecification basereq= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").setContentType(ContentType.JSON).build();
		
		return basereq;
	}

}
