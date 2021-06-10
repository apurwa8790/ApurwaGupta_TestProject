package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericConstants;

public class ItemCheckoutTest {
	
	ApplicationKeywords app = new ApplicationKeywords();
	GenericConstants constant = new GenericConstants();
	
	@Test
	public void checkOutTest() throws InterruptedException
	{
		app.defaultLogin();
		app.click(constant.tablet_id);
		app.scrollDown(1000);
		app.click(constant.addItem_xpath);
		app.click(constant.addToCart_xpath);
		app.click(constant.menuCart_id);
		app.click(constant.checkoutButton_id);
		app.validateText(constant.orderPayment_xpath, "ORDER PAYMENT");
		app.quit();
	}
	

}
