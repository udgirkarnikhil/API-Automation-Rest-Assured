package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void hooksdelete() throws IOException {
		
		StepDefinationAddPlace m = new StepDefinationAddPlace();
		if(StepDefinationAddPlace.placeid ==null) {
			
		m.add_place_payload_with("Nik", "USA", "http://nikhil.com");
		m.user_calls_a_pi_with_http_request("Addplace", "post");
		m.verify_id_generated_maps_with_with("Nik", "Getplace");
		}
		
	}

}
