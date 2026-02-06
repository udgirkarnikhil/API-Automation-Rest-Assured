package resources;

import pojo.Bookingdates;
import pojo.CreateBooking;

public class Payloads {
	
	
	public String CreateToken() {
		
		return "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
	}
	public CreateBooking UpdateBooking(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds) {
		
		CreateBooking c = new CreateBooking();
		c.setAdditionalneeds(additionalneeds);
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setDepositpaid(depositpaid);
		c.setTotalprice(totalprice);
		Bookingdates b = new Bookingdates();
		b.setCheckin("2024-12-12");
		b.setCheckout("2024-12-13");
		c.setBookingdates(b);
		return c;
	}
	
}
