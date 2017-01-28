package myprojects.project.model;

public class Product {

	private double price;
	private double salesTax;
	private double importTaxes;
	private String name;
	private int quantity;
	private boolean imported;
	private double priceWithTax;
	
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

	public double getImportTaxes() {
		return importTaxes;
	}

	private void setImportedTaxes(double importTaxes) {
		this.importTaxes = importTaxes;
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
		this.setImportedTaxes(imported==true? 0.05: 0);
		this.imported = imported;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}
	
}
