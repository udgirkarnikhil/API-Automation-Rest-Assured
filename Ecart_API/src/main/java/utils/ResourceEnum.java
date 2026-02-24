package utils;

public enum ResourceEnum {
	
	getproducts("/api/productsList"),
	getBrands("/api/brandsList"),
	searchProduct("/api/searchProduct"),
	login("/api/verifyLogin"),
	registerUser("/api/createAccount"),
	deleteUser("/api/deleteAccount"),
	updateuser("/api/updateAccount"),
	getUser("/api/getUserDetailByEmail");
	
	 String resource;

	ResourceEnum(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;	
		
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}
