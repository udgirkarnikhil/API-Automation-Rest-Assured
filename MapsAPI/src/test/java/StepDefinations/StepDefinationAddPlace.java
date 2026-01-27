package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reusableResources.APIresources;
import reusableResources.TestData;
import reusableResources.Utils;

public class StepDefinationAddPlace extends Utils{
	
	RequestSpecification addPlaceReq;
	ResponseSpecification resp;
	Response response;
	TestData data =new TestData();
	static String placeid;
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String website) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
				
		addPlaceReq = given().spec(requestSpecification()).body(data.AddPlacePayload(name,address,website));
		 
	}
	
	@When("user calls {string} APi with {string} http request")
	public void user_calls_a_pi_with_http_request(String resource, String method) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		APIresources reso= APIresources.valueOf(resource);//addplace
		
		System.out.println(reso.getresource());
		
		
		resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("post"))
		response = addPlaceReq.when().post(reso.getresource());
		if(method.equalsIgnoreCase("get"))
			response = addPlaceReq.when().get(reso.getresource());
		if(method.equalsIgnoreCase("put"))
			response = addPlaceReq.when().put(reso.getresource());
			
		
	}
	@Then("Place to be added successfully with status code {int}")
	public void place_to_be_added_successfully_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	
	}
	@Then("{string} in the response should be {string}")
	public void in_the_response_should_be(String key, String value) {
		
	    // Write code here that turns the phrase above into concrete actions	    
	    assertEquals(getjsonpath(response,key),value);
	    
	    
	}


	@Then("Verify ID generated maps with {string} with {string}")
	public void verify_id_generated_maps_with_with(String name, String resource) throws IOException {
		
		placeid=getjsonpath(response,"place_id");
		addPlaceReq = given().spec(requestSpecification()).queryParam("place_id",placeid);
		
		user_calls_a_pi_with_http_request(resource,"get");
		String actualname = getjsonpath(response,"name");
		assertEquals(actualname,name);
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		
		addPlaceReq = given().spec(requestSpecification()).body(data.deletepayload(placeid));
	    
	}
	
	@Given("Update place payload")
	public void update_place_payload() throws IOException {
		
		addPlaceReq = given().spec(requestSpecification()).body(data.updatepayload(placeid));
	   
	}


}
