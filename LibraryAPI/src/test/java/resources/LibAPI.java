package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddLib;
import pojo.DeleteLib;

import static io.restassured.RestAssured.*;

public class LibAPI extends Utils{
	
	public static void main (String[] args) {
		
		
		AddLib al = new AddLib();
		al.setName("nikhil");
		al.setIsbn("fgh");
		al.setAisle("227");
		al.setAuthor("Joseph");
					
		RequestSpecification addreq = given().log().all().spec(Reuseable()).body(al);
		
		Response response = addreq.when().post("/Library/Addbook.php")
		.then().statusCode(200).extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		String id = js.get("ID");
		System.out.println(id);
		
		DeleteLib dl = new DeleteLib();
		dl.setID("fgh227");
		
RequestSpecification reqdel = given().log().all().spec(Reuseable()).body(dl);

Response resp = reqdel.when().delete("/Library/DeleteBook.php");
		
		resp.then().log().all().assertThat().statusCode(200);
		
	}	
}
