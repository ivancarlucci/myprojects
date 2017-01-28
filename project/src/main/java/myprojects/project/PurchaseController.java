package myprojects.project;

public class PurchaseController {

	private Receipt receipt;
	
	public PurchaseController(){
		receipt = new Receipt();
	}
	
	public void purchaseProduct(Product product) {
		receipt.getProductsList().add(product);
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public void calculateTotalPrice() {
		double totalPrice = 0;
		for(Product p: receipt.getProductsList()){
			double priceWithSalesTax = p.getPrice()*p.getQuantity() + p.getPrice()*p.getSalesTax() + p.getPrice()*p.getImportedTax();
			double priceWithSalesTaxRounded = 0;
			if(p.getSalesTax()!=0){
				priceWithSalesTaxRounded = (Math.round(priceWithSalesTax*20.0))/20.0;//TODO bisogna metterlo prima su due cifre e poi approssimare forse(Math.round(priceWithSalesTax*20))/20.0;
			}else{
				priceWithSalesTaxRounded = priceWithSalesTax;
			}
			totalPrice = totalPrice + priceWithSalesTaxRounded;
		}
		receipt.setTotalPrice(Math.floor(totalPrice*100)/100);
//		receipt.setTotalPrice(totalPrice);
	}

	public void calculateTotalTax() {
		double totalTax = 0;
		for(Product p: receipt.getProductsList()){
			totalTax = totalTax + p.getPrice()*p.getImportedTax() + p.getPrice()*p.getSalesTax();
		}
		receipt.setTotalTax((Math.round(totalTax*20.0))/20.0);
	}
	
}
