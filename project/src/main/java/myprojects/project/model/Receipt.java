package myprojects.project.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Product> productsList;
	private double totalPrice;
	private double totalTaxes;
	
	public Receipt(){
		productsList = new ArrayList<Product>();
		totalPrice = 0;
		totalTaxes = 0;
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

	public double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

}
