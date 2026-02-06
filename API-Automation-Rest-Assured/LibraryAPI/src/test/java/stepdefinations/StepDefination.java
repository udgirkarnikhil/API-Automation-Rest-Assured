package stepdefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Payloads;
import resources.Utils;

public class StepDefination extends Utils{
	Response response,resp;
	static RequestSpecification addreq,reqdel;
	APIResources ar;
	static String Id;
	Payloads pl = new Payloads();
	
	
	@Given("valid payload related to add book")
	public void valid_payload_related_to_add_book() {
	    // Write code here that turns the phrase above into concrete actions			
		addreq = given().log().all().spec(Reuseable()).body(pl.addPayload());
	}
	@When("client calls {string} API with {string} method")
	public void client_calls_api_with_method(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		ar = APIResources.valueOf(resource);
		
		if(method.equalsIgnoreCase("post"))
		response = addreq.when().post(ar.getresource());
		if(method.equalsIgnoreCase("delete"))
			response = reqdel.when().delete(ar.getresource());
			

	}
	@Then("successful status code {int} displayed")
	public void successful_status_code_displayed(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.statusCode(),200);
	}
	@Then("verify ID is generated")
	public void verify_id_is_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(pl.getJson(response,"ID"));
	    Id = pl.getJson(response,"ID");
	}

	@Given("valid payload related to delete book")
	public void valid_payload_related_to_delete_book() {
	    // Write code here that turns the phrase above into concrete actions
		reqdel = given().log().all().spec(Reuseable()).body(pl.deletePayload(Id));;
	}

	@Then("verify book deletion message is displayed")
	public void verify_book_deletion_message_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions	
	System.out.println(pl.getJson(response, "msg"));
		
	}

}
