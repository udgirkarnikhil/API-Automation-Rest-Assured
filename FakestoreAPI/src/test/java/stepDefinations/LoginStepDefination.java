package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Payloads;
import resources.Utils;

public class LoginStepDefination extends Utils{

	Payloads pl = new Payloads();
	RequestSpecification loginreq;
	Response loginresp;
	
	@Given("I am having valid {string} and {string}")
	public void i_am_having_valid_and(String username, String password) throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		 loginreq=given().spec(getRequestSpec()).body(pl.getLogin(username,password));
	}
	@When("I send {string} request for {string}")
	public void i_send_request_for(String string, String string2) {
		 loginresp= loginreq.when().post("/auth/login");
	}
	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int code) {
		assertEquals(loginresp.getStatusCode(),code);
	}
	@Then("the response should contain a JWT token")
	public void the_response_should_contain_a_jwt_token() {
	    JsonPath js = new JsonPath(loginresp.asString());
	   String token= js.getString("token");
	   System.out.println(token);
	}
	@Then("the response should contain error message")
	public void the_response_should_contain_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	   loginresp.print();
	}
}
