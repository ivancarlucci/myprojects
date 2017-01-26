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
	
}
