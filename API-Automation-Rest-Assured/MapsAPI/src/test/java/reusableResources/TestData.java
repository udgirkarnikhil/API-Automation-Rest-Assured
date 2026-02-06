package reusableResources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {

	
	public AddPlace AddPlacePayload(String name, String address, String website) {
		
		AddPlace p = new AddPlace();
		
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 993 893 3937");
		p.setAddress(address);
		p.setWebsite(website);
		p.setLanguage("English");
		
		
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		
		List<String> type = new ArrayList<>();
		
		type.add("shoe park");
		type.add("shop");
		p.setTypes(type);
return p;
	}
	
	public String deletepayload(String Id) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+Id+"\"\r\n"
				+ "}";
	}

	public String updatepayload(String placeid) {
		// TODO Auto-generated method stub
		return "\"place_id\":\"\"+placeid+\"\",\r\n"
				+ "	\"address\":\"70 Summer walk, USA\",\r\n"
				+ "	\"key\":\"qaclick123\"";
			
			
	}
	
	
}
