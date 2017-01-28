package myprojects.project;

public class Product {

	private double price;
	private ProductType type;
	private double salesTax;
	private double importedTax;
	private String name;
	private int quantity;
	private boolean imported;
	
	public Product(){
		setSalesTax(0.10);
	}
	
	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

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

	public double getImportedTax() {
		return importedTax;
	}

	private void setImportedTax(double importedTax) {
		this.importedTax = importedTax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.setImportedTax(imported==true? 0.05: 0);
		this.imported = imported;
	}
	
}
