package pojo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.responsepojo.GetProducts;
import utils.ResourceEnum;
import utils.requestBuild;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.util.List;

public class Dummy {
	
	@Test
	public  void API () throws FileNotFoundException, JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
	
	payload_hashmap ph = new payload_hashmap();
	requestBuild rb =new requestBuild();
	ResourceEnum re;
	
	RequestSpecification basepostreq=given().spec(rb.getrequest());
	RequestSpecification basepostreq2=given().spec(rb.getrequest());
	RequestSpecification basepostreq3=given().spec(rb.getrequest());
	RequestSpecification basepostreq4=given().spec(rb.getrequest());
	RequestSpecification basegetreq=given().spec(rb.getrequest());
	
	re=ResourceEnum.valueOf("getproducts");
	
	RequestSpecification getprod=basegetreq;
	String htmlrep=getprod.when().get(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	Document doc = Jsoup.parse(htmlrep);
	
	String jsonrep=doc.body().text();
		
	System.out.println(jsonrep);
	
	JsonPath js=new JsonPath(jsonrep);
	String responsecode=js.getString("responseCode");
	
	List prodList=js.getList("products");
	
	System.out.println(prodList);
	System.out.println(responsecode);
	
	ObjectMapper mapper = new ObjectMapper();

	GetProducts resp = mapper.readValue(jsonrep, GetProducts.class);
	
	int respcode=resp.getResponseCode();
	System.out.println(respcode);
	
	re=ResourceEnum.valueOf("getBrands");
	
	basegetreq.when().get(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	re=ResourceEnum.valueOf("searchProduct");
	
	basepostreq.formParam("search_product","top")
	.when().post(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	re=ResourceEnum.valueOf("login");
	
	basepostreq2.formParam("password", "Test@123").formParam("email", "udgirkar@gmail.com")
	.when().post("/api/verifyLogin")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	re=ResourceEnum.valueOf("registerUser");
	
	basepostreq3.formParams(ph.getpayload())
	.when().post(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	re=ResourceEnum.valueOf("deleteUser");
	
	basepostreq4.formParam("password", "Maveric@2025").formParam("email", "tysy@gmail.com")
	.when().delete(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	re=ResourceEnum.valueOf("getUser");
	
	basegetreq.queryParam("email", "udgirkar@gmail.com")
	.when().get(re.getResource())
	.then().assertThat().statusCode(200).extract().response().asString();
	
	}

}
