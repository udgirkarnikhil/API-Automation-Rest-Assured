package resources;

public enum bookingEnum {
	
	CreateToken("/auth"),
	CreateBooking("/booking"),
	UpdateBooking("/%s"),
	deleteBooking("/booking/%s"),
	GetAllBooking("/booking");
	String resource;
	
	bookingEnum(String resource) {
		// TODO Auto-generated constructor stub
	
		this.resource = resource;
	}
	
	public  String getresource() {
		
		return resource;
	}
	
	public String getresourcewithID(String id) {
        return String.format(resource, id);
    }
}
