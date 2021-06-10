package keywords;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ValidationKeywords extends GenericKeywords {
	
	public void validateTitle(String text) {
		log("Validating title");
		String title = driver.getTitle();
		assertEquals(title, text);
	}
	
	public void validateText(String locator, String text) throws InterruptedException {
		Thread.sleep(2000);
		String data = getElement(locator).getText();
		assertTrue(data.equalsIgnoreCase(text));
	}
	
	public void validateElementPresent(String locator) {
		boolean result  = isElementPresent(locator);
		assertTrue(result);
	}
}
