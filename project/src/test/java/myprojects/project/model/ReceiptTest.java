package myprojects.project.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import myprojects.project.model.Receipt;

public class ReceiptTest {

	private Receipt receipt;
	
	@Before
	public void init(){
		receipt = new Receipt();
	}
	
	@Test
	public void receiptCreateTest() {
		receipt = new Receipt();
		assertNotNull(receipt);
	}
	
	@Test
	public void productListShouldBeEmptyAtTheBeginning(){
		assertEquals(0,receipt.getProductsList().size());
	}

}
