package cartPojo;

import java.util.List;

public class GetCart {
	
	private String id;
	private String userId;
	private String date;
	private List<Products> products;
	private String __v;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public String get__v() {
		return __v;
	}
	public void set__v(String __v) {
		this.__v = __v;
	}
	

}
