package myprojects.project;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Product> productsList;
	private double totalPrice;
	private double totalTax;
	
	public Receipt(){
		productsList = new ArrayList<Product>();
		totalPrice = 0;
		totalTax = 0;
	}
	
	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

}
