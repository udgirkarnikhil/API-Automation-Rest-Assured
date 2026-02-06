package resources;

public class Payloads {
	
	public String getLogin(String username, String password) {
		
		return "{\r\n"
				+ "  \"username\": \""+username+"\",\r\n"
				+ "  \"password\": \""+password+"\"\r\n"
				+ "}";
	}
	
	public String getAddUser(String id, String username, String email, String password) {
		
		return "{\r\n"
				+ "  \"id\": "+id+",\r\n"
				+ "  \"username\": \""+username+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"password\": \""+password+"\"\r\n"
				+ "}";
	}
	
public String getUpdateUser() {
		
		return "{\r\n"
				+ "  \"id\": 1383,\r\n"
				+ "  \"username\": \"johnd\",\r\n"
				+ "  \"email\": \"john@gmail.com\",\r\n"
				+ "  \"password\": \"m38rmF$\"\r\n"
				+ "}";
		
		
	}
public String getAddCart() {
	
	return "{\r\n"
			+ "  \"id\": 9716,\r\n"
			+ "  \"userId\": 7207,\r\n"
			+ "  \"products\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 4483,\r\n"
			+ "      \"title\": \"string\",\r\n"
			+ "      \"price\": 4677.167455132947,\r\n"
			+ "      \"description\": \"string\",\r\n"
			+ "      \"category\": \"string\",\r\n"
			+ "      \"image\": \"https://eeJvdUbgBzdJNDuyXpqbuIXXW.xlzwYxWmuUDi1hMMWmT4H9,sLmiLUwl8z6mfFTUP9nXogcBmnpzj2vXzJFjZcN\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": 6181,\r\n"
			+ "      \"title\": \"string\",\r\n"
			+ "      \"price\": 7366.227140151669,\r\n"
			+ "      \"description\": \"string\",\r\n"
			+ "      \"category\": \"string\",\r\n"
			+ "      \"image\": \"http://cTFgARVtApJcHUJLffupcdkVBdjKk.qopnWWidO,CtWAUWO8GJBP\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	
}
public String getUpdateCart() {
	
	return "{\r\n"
			+ "  \"id\": 9716,\r\n"
			+ "  \"userId\": 7207,\r\n"
			+ "  \"products\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 4483,\r\n"
			+ "      \"title\": \"string\",\r\n"
			+ "      \"price\": 4677.167455132947,\r\n"
			+ "      \"description\": \"string\",\r\n"
			+ "      \"category\": \"string\",\r\n"
			+ "      \"image\": \"https://eeJvdUbgBzdJNDuyXpqbuIXXW.xlzwYxWmuUDi1hMMWmT4H9,sLmiLUwl8z6mfFTUP9nXogcBmnpzj2vXzJFjZcN\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": 6181,\r\n"
			+ "      \"title\": \"string\",\r\n"
			+ "      \"price\": 7366.227140151669,\r\n"
			+ "      \"description\": \"string\",\r\n"
			+ "      \"category\": \"string\",\r\n"
			+ "      \"image\": \"http://cTFgARVtApJcHUJLffupcdkVBdjKk.qopnWWidO,CtWAUWO8GJBP\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	
}

public String getUpdateProduct() {
	// TODO Auto-generated method stub
	return "{\r\n"
			+ "  \"id\": 9216,\r\n"
			+ "  \"title\": \"string\",\r\n"
			+ "  \"price\": 7359.18064081919,\r\n"
			+ "  \"description\": \"string\",\r\n"
			+ "  \"category\": \"string\",\r\n"
			+ "  \"image\": \"https://PUG.fazel4c2kvJi5sQMt3x3vIuPyizgCi-vxs6di7-KAb3VO.ENrUgN9RxpI\"\r\n"
			+ "}";
}

public String getAddProduct() {
	// TODO Auto-generated method stub
	return "{\r\n"
			+ "  \"id\": 9216,\r\n"
			+ "  \"title\": \"string\",\r\n"
			+ "  \"price\": 7359.18064081919,\r\n"
			+ "  \"description\": \"string\",\r\n"
			+ "  \"category\": \"string\",\r\n"
			+ "  \"image\": \"https://PUG.fazel4c2kvJi5sQMt3x3vIuPyizgCi-vxs6di7-KAb3VO.ENrUgN9RxpI\"\r\n"
			+ "}";
}

}