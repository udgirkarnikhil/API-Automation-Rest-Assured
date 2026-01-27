package resources;

public class Reuseablebody {

	public String loginBody() {
		
return "{\r\n"
		+ "  \"username\": \"jsmith\",\r\n"
		+ "  \"password\": \"demo1234\"\r\n"
		+ "}";
		
	}
	
	public String actStatement() {
		
		return "{\r\n"
				+ "  \"startDate\": \"2026-01-12\",\r\n"
				+ "  \"endDate\": \"2026-01-16\"\r\n"
				+ "}";
	}
	
	public String feedback() {
		
		return "{\r\n"
				+ "  \"name\": \"J Smith\",\r\n"
				+ "  \"email\": \"jsmtih@altoromutual.com\",\r\n"
				+ "  \"subject\": \"Amazing web design\",\r\n"
				+ "  \"message\": \"I like the new look of your applicaiton\"\r\n"
				+ "}";
	}
	
	public String addUserbody() {
		
		return "{\r\n"
				+ "  \"firstname\": \"Bilbo\",\r\n"
				+ "  \"lastname\": \"Baggins\",\r\n"
				+ "  \"username\": \"bilbob\",\r\n"
				+ "  \"password1\": \"S3l3ctS0methingStr0ng5AsP@ssword\",\r\n"
				+ "  \"password2\": \"S3l3ctS0methingStr0ng5AsP@ssword\"\r\n"
				+ "}";
	}
	
	public String fundtransfer() {
		
		return "{\r\n"
				+ "  \"toAccount\": \"800003\",\r\n"
				+ "  \"fromAccount\": \"800002\",\r\n"
				+ "  \"transferAmount\": \"200\"\r\n"
				+ "}";
	}
}
