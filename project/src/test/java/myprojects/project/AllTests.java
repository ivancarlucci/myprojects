package myprojects.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import myprojects.project.model.ReceiptTest;

@RunWith(Suite.class)
@SuiteClasses({ PurchaseControllerTest.class, ReceiptTest.class })
public class AllTests {

}
