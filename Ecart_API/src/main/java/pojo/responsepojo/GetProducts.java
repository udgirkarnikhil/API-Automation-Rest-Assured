package pojo.responsepojo;

import java.util.List;

public class GetProducts {
	
	private int responseCode;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	private List<Products> products;

}
