package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.payload_hashmap;
import pojo.responsepojo.GetProducts;
import pojo.responsepojo.Products;
import utils.ResourceEnum;
import utils.requestBuild;

public class StepDefinations {

	payload_hashmap ph = new payload_hashmap();
	requestBuild rb = new requestBuild();
	ResourceEnum re;
	
	RequestSpecification basepostreq,basepostreq2,basepostreq3,basepostreq4,basegetreq,getprod;	
	GetProducts resp;
	String jsonrep;
	int responsecode;
	JsonPath js;
	String htmlrep;

	@Given("the API {string} is available")
	public void the_api_is_available(String string) throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		basepostreq=given().spec(rb.getrequest());
		basepostreq2=given().spec(rb.getrequest());
		basepostreq3=given().spec(rb.getrequest());
		basepostreq4=given().spec(rb.getrequest());
		basegetreq=given().spec(rb.getrequest());
		re=ResourceEnum.valueOf(string);
		
		getprod=basegetreq;
		
	}
	@When("User sends {string} request")
	public void user_sends_request(String method) throws JsonMappingException, JsonProcessingException {
	    // Write code here that turns the phrase above into concrete actions
		
		if (method.equalsIgnoreCase("get")){
			htmlrep=getprod.when().get(re.getResource())
					.then().extract().response().asString();
		}
		if (method.equalsIgnoreCase("post")){
			
			htmlrep=getprod.when().post(re.getResource())
					.then().extract().response().asString();
		}
		if (method.equalsIgnoreCase("delete")) {
			htmlrep=getprod.when().delete(re.getResource())
					.then().extract().response().asString();
		}
		if (method.equalsIgnoreCase("put")) {
			htmlrep=getprod.when().put(re.getResource())
					.then().extract().response().asString();

		}

	}
	
	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int expectedStatusCode) {

	    // Convert HTML to plain text
	    Document doc = Jsoup.parse(htmlrep);
	    jsonrep = doc.body().text();
	    System.out.println(jsonrep);
	    js = new JsonPath(jsonrep);
	    responsecode = js.getInt("responseCode");
	    assertEquals(expectedStatusCode,responsecode);

	}
	
	@Then("the response should display list of products")
	public void the_response_should_display_list_of_products() {
	    // Write code here that turns the phrase above into concrete actions
		
		List products= js.getList("products");
		System.out.println(products);
		
	}
	
	@Then("the response message should display")
	public void the_response_message_should_display() {
	    // Write code here that turns the phrase above into concrete actions
	    String mes = js.getString("message");
	    System.out.println(mes);

	}
	
	@Then("the response should display list of brands")
	public void the_response_should_display_list_of_brands() {
	    // Write code here that turns the phrase above into concrete actions
		List Brands = js.getList("brands");
		System.out.println("**********************");
		System.out.println(Brands);
		System.out.println("**********************");
	}
	
	@When("user sends {string} request with {string} key")
	public void user_sends_request_with_key(String String, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		htmlrep = basepostreq.formParam("search_product",string2)
		.when().post(re.getResource())
		.then().extract().response().asString();
		System.out.println(htmlrep);
		
	}
		
	@Then("the response should contain list of products for serached key")
	public void the_response_should_contain_list_of_products_for_serached_key() {
	    // Write code here that turns the phrase above into concrete actions
	    	    
	    String searchprod = js.getString("products");
	    System.out.println(searchprod);
	    System.out.println("********************************");
	}

	@When("user sends {string} request without search_product key")
	public void user_sends_request_without_search_product_key(String string) {
	    // Write code here that turns the phrase above into concrete actions
		htmlrep = basepostreq
		.when().post(re.getResource())
		.then().extract().response().asString();
		System.out.println(htmlrep);
		
	}

	@When("user sends {string} request with {string} and {string}")
	public void user_sends_request_with_and(String method, String string2, String string3) {
    // Write code here that turns the phrase above into concrete actions
		
		if (method.equalsIgnoreCase("post")){
		
		htmlrep = basepostreq3.formParam("email",string2).formParam("password",string3 )
				.when().post(re.getResource())
				.then().extract().response().asString();
				System.out.println(htmlrep);
		}
		if(method.equalsIgnoreCase("delete")){
		htmlrep = basepostreq3.formParam("email",string2).formParam("password",string3 )
				.when().delete(re.getResource())
				.then().extract().response().asString();
				System.out.println(htmlrep);
						
		}
}
	@When("user sends {string} request with {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_sends_request_with(String method, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18) 
	{    // Write code here that turns the phrase above into concrete actions
		if(method.equalsIgnoreCase("post")) {
		htmlrep = basepostreq4.formParam("name",string2).formParam("email",string3)
				.formParam("password", string4)
				.formParam("title", string5)
				.formParam("birth_date", string6)
				.formParam("birth_month", string7)
				.formParam("birth_year", string8)
				.formParam("firstname", string9)
				.formParam("lastname", string10)
				.formParam("company", string11)
				.formParam("address1", string12)
				.formParam("address2", string13)
				.formParam("country", string14)
				.formParam("zipcode", string15)
				.formParam("state", string16)
				.formParam("city", string17)
				.formParam("mobile_number", string18)
				.when().post(re.getResource())
				.then().extract().response().asString();
				System.out.println(htmlrep);
		}
		if(method.equalsIgnoreCase("put")) {
			htmlrep = basepostreq4.formParam("name",string2).formParam("email",string3)
					.formParam("password", string4)
					.formParam("title", string5)
					.formParam("birth_date", string6)
					.formParam("birth_month", string7)
					.formParam("birth_year", string8)
					.formParam("firstname", string9)
					.formParam("lastname", string10)
					.formParam("company", string11)
					.formParam("address1", string12)
					.formParam("address2", string13)
					.formParam("country", string14)
					.formParam("zipcode", string15)
					.formParam("state", string16)
					.formParam("city", string17)
					.formParam("mobile_number", string18)
					.when().put(re.getResource())
					.then().extract().response().asString();
					System.out.println(htmlrep);
			}
	}

	@When("user sends {string} request with {string}")
	public void user_sends_request_with(String string, String email) {
	    // Write code here that turns the phrase above into concrete actions
		htmlrep= basegetreq.queryParam("email",email)
		.when().get(re.getResource()).then().extract().response().asString();
		System.out.println(htmlrep);
	  
	}
	@Then("the response should display user details")
	public void the_response_should_display_user_details() {
		System.out.println("id="+js.get("user.id"));
		
	    
	}

}
