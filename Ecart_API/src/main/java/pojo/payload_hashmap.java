package pojo;

import java.util.HashMap;
import java.util.Map;

public class payload_hashmap {
	
	
	public Map<String, Object> getpayload() {
		
		Map<String, Object> formdata = new HashMap<>();
		
		formdata.put("name", "nikhil");
		formdata.put("email", "tyst@gmail.com");
		formdata.put("password", "Maveric@2025");
		formdata.put("title", "Mr");
		formdata.put("birth_date", "30");
		formdata.put("birth_month", "01");
		formdata.put("birth_year", "1998");
		formdata.put("firstname", "Sanjay");
		formdata.put("lastname", "Dutt");
		formdata.put("company", "Google");
		formdata.put("address1", "8233 south");
		formdata.put("address2", "blvd");
		formdata.put("country", "SA");
		formdata.put("zipcode", "23345");
		formdata.put("state", "georgia");
		formdata.put("city", "atlanta");
		formdata.put("mobile_number", "9086542765");
		
		return formdata;
	}

}
