package stepDefinations;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.FakeStoreResources;
import resources.Payloads;
import resources.Utils;
import userpojo.GetUser;

public class UsersStepDefination extends Utils{
	
	RequestSpecification userreq,adduserreq;
	Payloads pl=new Payloads();
	Response userresp;
	
	@Given("the Fake Store API is available for users")
	public void the_fake_store_api_is_available_for_users() throws FileNotFoundException {
	    userreq=given().spec(getRequestSpec());
	}
	@Given("User is having valid {string} {string} {string} and {string}")
	public void user_is_having_valid_and(String id, String username, String email, String password) {
		
		adduserreq =userreq.body(pl.getAddUser(id,username,email,password));
	    
	}
	@When("User sends {string} method with {string} API")
	public void user_sends_method_with_api(String method, String resource) {
		FakeStoreResources path = FakeStoreResources.valueOf(resource);
		if(method.equalsIgnoreCase("post"))
		{
		userresp=adduserreq.when().post(path.getresourcewithoutID());
		}
		if(method.equalsIgnoreCase("get")) {
			userresp=userreq.when().get(path.getresourcewithoutID());
		}
	}
	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(int code) {
		
		int statuscode=userresp.getStatusCode();
		assertEquals(statuscode,code);
	}
	@Then("id is generated")
	public void id_is_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(userresp.print());
	}
	@When("I send a {string} request to {string} with {string}")
	public void i_send_a_request_to_with(String method, String resourece, String id) {
		
		String idpath = FakeStoreResources.getusersbyID.getresourcewithID(id);
		
		userresp=userreq.when().get(idpath);
		
		
	    
	}
	@Then("Display user details of {string}")
	public void display_user_details_of(String id) {
	    // Write code here that turns the phrase above into concrete actions
		List<GetUser> users = Arrays.asList(userresp.as(GetUser[].class));
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id))
			{
				System.out.println(users.get(i).getId());
				System.out.println(users.get(i).getUsername());
				System.out.println(users.get(i).getPassword());
				
				
				}
			
			}
		
		
	}


	



}
