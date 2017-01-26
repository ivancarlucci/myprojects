package myprojects.project;

public class Product {

	private double price;
	private ProductType type;
	
	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public ProductType getType() {
		return type;
	}
	
}
