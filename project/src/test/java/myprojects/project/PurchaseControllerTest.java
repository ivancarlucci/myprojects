package myprojects.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PurchaseControllerTest {
	
	private PurchaseController purchaseController;
	
	@Before
	public void init(){
		purchaseController = new PurchaseController();
	}

	@Test
	public void purchaseControllerCreateTest() {
		purchaseController = new PurchaseController();
		assertNotNull(purchaseController);
	}
	
	@Test
	public void purchaseProduct(){
		Product product = new Product(); 
		purchaseController.purchaseProduct(product);
		assertEquals(1, purchaseController.getReceipt().getProductsList().size());
	}
	
	@Test
	public void input1(){
		Product book = new Product();
		book.setPrice(12.49);
		book.setType(ProductType.BOOK);
		purchaseController.purchaseProduct(book);
		Product musicCD = new Product();
		musicCD.setPrice(14.99);
		purchaseController.purchaseProduct(musicCD);
		Product chocolateBar = new Product();
		chocolateBar.setPrice(0.85);
		purchaseController.purchaseProduct(chocolateBar);
		assertEquals(3,purchaseController.getReceipt().getProductsList().size());
	}
	
}
