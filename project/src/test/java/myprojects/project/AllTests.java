package myprojects.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class, PurchaseControllerTest.class, ReceiptTest.class })
public class AllTests {

}
