package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddLib;
import pojo.DeleteLib;

public class Payloads {
	
	public AddLib addPayload() {
	AddLib al = new AddLib();
	al.setName("nikhil");
	al.setIsbn("ght");
	al.setAisle("227");
	al.setAuthor("Joseph");
	
	return al;
	}
	
	
	public DeleteLib deletePayload(String id) {
		DeleteLib dl = new DeleteLib();
		dl.setID(id);
		
		return dl;
	}
	
	public String getJson(Response response,String Key) {
		
			
	JsonPath js = new JsonPath(response.asString());
		return js.getString(Key);
	}

}
