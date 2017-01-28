package myprojects.project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		assertEquals(0,receipt.getProductsList().size());
	}
	
	
	

}
