package resources;

public enum ReuseEnum {
	
	login("/login"),
	Accountlist("/account"),
	AccountBalance("/account/{accountNo}"),
	AccountStatement("/account/{accountNo}/transactions"),
	transfer("/transfer"),
	feedback("/feedback/submit"),
	AddUser("/admin/addUser"),
	logout("/logout");
	
	String resource;

	ReuseEnum(String resource) {
		// TODO Auto-generated constructor stub
		
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}


}
