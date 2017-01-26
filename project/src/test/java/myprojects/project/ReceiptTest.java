package myprojects.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	public void getProductsList(){
		assertNotNull(receipt.getProductsList());
	}
	
	

}
