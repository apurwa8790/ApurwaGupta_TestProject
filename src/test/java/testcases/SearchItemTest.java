package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericConstants;

public class SearchItemTest {
	
	ApplicationKeywords app = new ApplicationKeywords();
	GenericConstants constant = new GenericConstants();
	
	@Test
	public void addCart() throws InterruptedException
	{
		app.defaultLogin();
		app.click(constant.tablet_id);
		app.scrollDown(1000);
		app.click(constant.addItem_xpath);
		String itemAdded = app.getText(constant.addItem_xpath);
		app.click(constant.addToCart_xpath);
		app.click(constant.menuCart_id);
		app.validateText(constant.itemAdded_xpath, itemAdded);
		app.quit();
	}

}
