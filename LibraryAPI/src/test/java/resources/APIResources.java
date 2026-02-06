package resources;

public enum APIResources {
	
	AddBook("/Library/Addbook.php"),
	DeleteBook("/Library/DeleteBook.php");
	String resource;
	
	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		
	this.resource = resource;	
	}

	public String getresource() {
		
		return resource;
	}
	
	
}
