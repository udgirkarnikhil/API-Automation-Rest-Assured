package stepDefinations;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Bookingdates;
import pojo.CreateBooking;
import resources.Payloads;
import resources.Utils;
import resources.bookingEnum;

import static io.restassured.RestAssured.*;
public class HotelBooking extends Utils{
	
	
	
	public static void main(String[] args) {
		
		RequestSpecification updateReq,delReq, tokenReq;
		Response updateResponse, delRes;
		bookingEnum b ;
		String resource;
	
		//Create Token		
		resource = "CreateToken";
		Payloads p = new Payloads();
		b = bookingEnum.valueOf(resource);
		
		tokenReq = given().spec(ReqSpec()).body(p.CreateToken());
		
		Response tokenresp = tokenReq.when().post(b.getresource());
		JsonPath js = new JsonPath(tokenresp.asString());
		
		String token = js.getString("token");
		System.out.println(token);
		
		
		
		//Create booking
		
		String firstname="Jim";
		String lastname = "Brown";
		int totalprice = 111;
		boolean depositpaid = true;
		String additionalneeds = "Breakfast";
        String checkin = "2024-01-01";
        String checkout = "2024-01-05";
        resource = "CreateBooking";
        b = bookingEnum.valueOf(resource);
        
		
		RequestSpecification createbookreq = given().log().all().spec(ReqSpec()).body(p.UpdateBooking(firstname,lastname,totalprice,depositpaid,checkin, checkout,additionalneeds));
		Response createbookres = createbookreq.when().post(b.getresource());
		JsonPath js1 = new JsonPath(createbookres.asString());
		String Bookingid = js1.getString("bookingid");
		System.out.println(Bookingid);
		
		//Update Booking
		
		firstname="Nik";
		lastname = "B";
		totalprice = 122;
		depositpaid = false;
		additionalneeds = "Lunch";
        checkin = "2024-01-02";
        checkout = "2024-01-04";
        String re = bookingEnum.UpdateBooking.getresourcewithID(Bookingid);
		
		updateReq = given().spec(ReqSpec()).header("cookie", token).body(p.UpdateBooking(firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds));
		updateResponse = updateReq.when().log().all().post(re);
		
		//delete Booking
		
		String res = bookingEnum.deleteBooking.getresourcewithID(Bookingid);
		
		delReq = given().spec(ReqSpec()).header("cookie", token);
		delRes = delReq.when().log().all().post(res);
		System.out.println(delRes);
		
		//Get all bookings
		
		resource = "GetAllBooking";
		b = bookingEnum.valueOf(resource);
				
		String response = given().spec(ReqSpec())
		.when().log().all().get(b.getresource())
		.then().extract().response().asString();
		System.out.println(response);
		
		
		
		
		
		
		
		
		

	}
	
	
	
}
