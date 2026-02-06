package stepDefinations;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ReuseEnum;
import resources.Reuseablebody;
import resources.Utils;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import POJO.AcList;

public class StepDefinations extends Utils {
	
	Reuseablebody rb=new Reuseablebody();
	RequestSpecification basereq,LoginReq,reqbal,reqfeedback,requser;
	static Response resp,resp1,resp2,resp3,resp4,resfeedback,resuser,resp5;
	static String Token;
	static ArrayList<String> acct;
	ReuseEnum re;
	static JsonPath js1;
	//Login
	@Given("User has given valid username and Password")
	public void user_has_given_valid_username_and_password() throws FileNotFoundException {
				
		LoginReq = given().spec(getRequestSpecification()).body(rb.loginBody());
		
	}
	@When("User calls login api with {string} method")
	public void user_calls_login_api_with_method(String string)  {
		
		 resp=LoginReq.when().post("/login")
		.then().statusCode(200).extract().response();
		
	    
	}
	@Then("verify status code id {int}")
	public void verify_status_code_id(Integer int1) {
	    assertEquals(resp.getStatusCode(),200);
	}
	@Then("User is having {string} Token")
	public void user_is_having_token(String Authorization) {
		
		String jsrespo = resp.asString();
	    
		JsonPath js = new JsonPath(jsrespo);
		Token = js.get(Authorization);
		System.out.println(Token);
	}
	
	//Accounts List
	@When("User calls {string} api with {string} method")
	public void user_calls_api_with_method(String resource, String method) throws FileNotFoundException {
	    
		re=ReuseEnum.valueOf(resource);
		System.out.println(re.getResource());
		
		 resp1=given().spec(getRequestSpecification()).header("Authorization",Token).when().get(re.getResource());
	}
	@Then("User is having list of accounts")
	public void user_is_having_list_of_accounts() {
		
		
		AcList actlist=resp1.as(AcList.class);
		
		acct = new  ArrayList<String>();
		
		int count=actlist.getAccounts().size();
		
		
		for(int i=0;i<count;i++) {
		
		String accountId = actlist.getAccounts().get(i).getId();
		acct.add(accountId);
		}
		System.out.println(acct);

	}
	
	//Account Balance
	@Given("User is having list of accounts and {string} Token")
	public void user_is_having_list_of_accounts_and_token(String string) throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
	    reqbal = given().spec(getRequestSpecification()).pathParam("accountNo",acct.get(0)).header("Authorization", Token);
	}

	@When("User calls AccountBalance api with {string} method")
	public void user_calls_account_balance_api_with_method(String string) {
	    // Write code here that turns the phrase above into concrete actions
	 
		resp2 = reqbal.when().get(re.AccountBalance.getResource());
	}
	
	@Then("verify account balance displayed")
	public void verify_account_balance_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    String accountbalance= resp2.asString();
	    
	    System.out.println(accountbalance);
	     js1 = new JsonPath(accountbalance);
	    String balance=js1.getString("balance");	    
	    System.out.println(balance);
	}
	@When("User calls AccountStatement api with {string} method")
	public void user_calls_account_statement_api_with_method(String string) {
		
		 reqbal.when().get(re.AccountStatement.getResource());
	}
	@Then("account statement is displayed with recent {int} transactions")
	public void account_statement_is_displayed_with_recent_transactions(Integer int1) {
		
	    
		  String balance=js1.getString("last_10_transactions");
	      
	    System.out.println(balance);
	}


@Then("verify AccountStatement is displayed for specific data range")
public void verify_account_statement_is_displayed_for_specific_data_range() {
    
	resp3 = reqbal.body(rb.actStatement()).when().get(re.AccountStatement.getResource());
	
	String acctstament =resp3.asString();
	System.out.println(acctstament);
}

@When("User calls funds transfer api with {string} method")
public void user_calls_funds_transfer_api_with_method(String string) throws FileNotFoundException {
	
	resp4=given().spec(getRequestSpecification())
			.header("Authorization", Token)
			.body(rb.fundtransfer())
			.when().post(re.transfer.getResource());
   
}
@Then("verify successful funds transfer message displayed")
public void verify_successful_funds_transfer_message_displayed() {
    
	String message=resp4.asString();
	System.out.println(message);
}

@Given("User enters all mandatory details and {string} Token")
public void user_enters_all_mandatory_details_and_token(String string) throws FileNotFoundException {
    // Write code here that turns the phrase above into concrete actions

 reqfeedback =given().spec(getRequestSpecification())
	.header("Authorization", Token)
	.body(rb.feedback());


}
@When("User calls feedback api with {string} method")
public void user_calls_feedback_api_with_method(String string) {
    // Write code here that turns the phrase above into concrete actions
 resfeedback=reqfeedback.when().post(re.feedback.getResource());
}
@Then("view the Feedback details")
public void view_the_feedback_details() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(resfeedback.asString());
}

@Given("User adds all required details and {string} Token")
public void user_adds_all_required_details_and_token(String string) throws FileNotFoundException {
    // Write code here that turns the phrase above into concrete actions
requser = 	given().spec(getRequestSpecification())
	.header("Authorization", Token)
	.body(rb.addUserbody());

}
@When("User calls AddUser api with {string} method")
public void user_calls_add_user_api_with_method(String string) {
    // Write code here that turns the phrase above into concrete actions
 resuser = requser.when().post(re.AddUser.getResource());
}
@Then("verify user added all required details")
public void verify_user_added_all_required_details() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(resuser.asString());
}

@When("User call logout api with {string} method")
public void user_call_logout_api_with_method(String string) throws FileNotFoundException {
    // Write code here that turns the phrase above into concrete actions
resp5 = given().spec(getRequestSpecification()).header("Authorization", Token).when().get(re.logout.getResource());
}
@Then("verify user logout message is displayed")
public void verify_user_logout_message_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(resp5.asString());
}
}

