package reusableResources;

public enum APIresources {
	
	Addplace("/maps/api/place/add/json"),
	Getplace("/maps/api/place/get/json"),
	Deleteplace("/maps/api/place/delete/json"),
	Updateplace("/maps/api/place/update/json");
	
	
	String resource;//maps/api/place/add/json"

	APIresources(String resource) { //addplace
		
		this.resource=resource;
	}
	
	public  String getresource()
	{
		return resource;//maps/api/place/add/json"
	}
	

}
