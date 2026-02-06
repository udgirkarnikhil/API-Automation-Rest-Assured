package resources;

public enum FakeStoreResources {
	
	createUser("/users"),
	getusers("/users"),
	getusersbyID("/users/%s");

	 String resource;
	FakeStoreResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getresourcewithoutID() {
		return resource;
	}
	
	public String getresourcewithID(String id) {
        return String.format(resource, id);
    }


}
