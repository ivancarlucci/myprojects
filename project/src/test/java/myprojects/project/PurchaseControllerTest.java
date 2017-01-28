package myprojects.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

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
	public void calculateTotalPrice(){
		Product product1 = new Product();
		product1.setPrice(11);
		product1.setQuantity(1);
		product1.setImported(true);
		Product product2 = new Product();
		product2.setPrice(10);
		product2.setImported(false);
		product2.setQuantity(1);
		purchaseController.getReceipt().setProductsList(Arrays.asList(product1,product2));
		purchaseController.calculateTotalPrice();
		assertEquals(Double.valueOf(23.705), Double.valueOf(purchaseController.getReceipt().getTotalPrice()));//12,705+11
	}
	
	@Test
	public void calculateTotalTax(){
		Product product1 = new Product();
		product1.setPrice(11);
		product1.setQuantity(1);
		product1.setImported(true);
		Product product2 = new Product();
		product2.setPrice(10);
		product2.setImported(false);
		product2.setQuantity(1);
		purchaseController.getReceipt().setProductsList(Arrays.asList(product1,product2));
		purchaseController.calculateTotalTax();
		assertEquals(Double.valueOf(2.65), Double.valueOf(purchaseController.getReceipt().getTotalTax()));
	}
	
	@Test
	public void input1(){
		Product book = new Book();
		book.setPrice(12.49);
		book.setQuantity(1);
		book.setName("Book");
		purchaseController.purchaseProduct(book);
		Product musicCD = new Product();
		musicCD.setPrice(14.99);
		musicCD.setQuantity(1);
		musicCD.setName("Music CD");
		purchaseController.purchaseProduct(musicCD);
		Product chocolateBar = new Food();
		chocolateBar.setPrice(0.85);
		chocolateBar.setQuantity(1);
		chocolateBar.setName("Chocolate");
		purchaseController.purchaseProduct(chocolateBar);
		assertEquals(3,purchaseController.getReceipt().getProductsList().size());
		purchaseController.calculateTotalPrice();
		purchaseController.calculateTotalTax();
		assertEquals(Double.valueOf(12.49), Double.valueOf(purchaseController.getReceipt().getProductsList().get(0).getPrice()));
		assertEquals(Double.valueOf(14.99), Double.valueOf(purchaseController.getReceipt().getProductsList().get(1).getPrice()));
		assertEquals(Double.valueOf(0.85), Double.valueOf(purchaseController.getReceipt().getProductsList().get(2).getPrice()));
		assertEquals(Double.valueOf(29.84), Double.valueOf(purchaseController.getReceipt().getTotalPrice()));
		assertEquals(Double.valueOf(1.50), Double.valueOf(purchaseController.getReceipt().getTotalTax()));
		
		System.out.println("Product list purchased:");
		for(Product p : purchaseController.getReceipt().getProductsList()){
			System.out.println("- "+p.getQuantity()+" - "+p.getName());
		}
		System.out.println("Total price: "+purchaseController.getReceipt().getTotalPrice());
		System.out.println("Total tax: "+purchaseController.getReceipt().getTotalTax());
	}
	
	@Test
	public void input2(){
		Product boxChocolate = new Food();
		boxChocolate.setPrice(10);
		boxChocolate.setQuantity(1);
		boxChocolate.setImported(true);
		boxChocolate.setName("Box of chocolates");
		Product bottlePerfume = new Product();
		bottlePerfume.setPrice(47.5);
		bottlePerfume.setQuantity(1);
		bottlePerfume.setImported(true);
		bottlePerfume.setName("Bottle of perfume");
		purchaseController.purchaseProduct(boxChocolate);
		purchaseController.purchaseProduct(bottlePerfume);
		purchaseController.calculateTotalPrice();
		purchaseController.calculateTotalTax();
		assertEquals(Double.valueOf(65.15), Double.valueOf(purchaseController.getReceipt().getTotalPrice()));
		assertEquals(Double.valueOf(7.65), Double.valueOf(purchaseController.getReceipt().getTotalTax()));
		
		System.out.println("Product list purchased:");
		for(Product p : purchaseController.getReceipt().getProductsList()){
			System.out.println("- "+p.getQuantity()+" - "+p.getName());
		}
		System.out.println("Total price: "+purchaseController.getReceipt().getTotalPrice());
		System.out.println("Total tax: "+purchaseController.getReceipt().getTotalTax());
	}
	
	@Test
	public void input3(){
		Product bottlePerfume = new Product();
		bottlePerfume.setPrice(27.99);
		bottlePerfume.setQuantity(1);
		bottlePerfume.setImported(true);
		bottlePerfume.setName("Bottle of perfume");
		Product bottlePerfume2 = new Product();
		bottlePerfume2.setPrice(18.99);
		bottlePerfume2.setQuantity(1);
		bottlePerfume2.setImported(false);
		bottlePerfume2.setName("Bottle of perfume");
		Product packetOfPills = new Medical();
		packetOfPills.setPrice(9.75);
		packetOfPills.setQuantity(1);
		packetOfPills.setImported(false);
		packetOfPills.setName("Packet of pills");
		Product boxOfChocolates = new Food();
		boxOfChocolates.setPrice(11.25);
		boxOfChocolates.setQuantity(1);
		boxOfChocolates.setImported(true);
		boxOfChocolates.setName("Box of imported chocolates");
		purchaseController.purchaseProduct(bottlePerfume);
		purchaseController.purchaseProduct(bottlePerfume2);
		purchaseController.purchaseProduct(packetOfPills);
		purchaseController.purchaseProduct(boxOfChocolates);
		purchaseController.calculateTotalPrice();
		purchaseController.calculateTotalTax();
		assertEquals(Double.valueOf(74.68), Double.valueOf(purchaseController.getReceipt().getTotalPrice()));
		assertEquals(Double.valueOf(6.70), Double.valueOf(purchaseController.getReceipt().getTotalTax()));
	}
	
}
