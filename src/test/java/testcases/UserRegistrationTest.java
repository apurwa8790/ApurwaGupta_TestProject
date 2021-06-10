package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericConstants;

public class UserRegistrationTest {
	
	ApplicationKeywords app = new ApplicationKeywords();
	GenericConstants constants = new GenericConstants();
	
	@Test
	public void registrationSuccess() throws InterruptedException
	{
		app.openBrowser(constants.Chrome);
		app.navigate(constants.url);
		app.click(constants.userIcon_id);
		app.click(constants.createNewAccount_xpath);
		app.validateTitle(constants.Advantage_Shopping);
		app.type(constants.username_xpath, app.generateRandomUsername());
		app.type(constants.email_xpath, "apurwa@gmail.com");
		app.type(constants.password_xpath, "Pass1");
		app.type(constants.confirmPassword_xpath, "Pass1");
		app.click(constants.agreeCheckBox_xpath);
		app.click(constants.registerButton_id);
		app.validateTitle(constants.Advantage_Shopping);
		app.validateElementPresent(constants.MenuBar_xpath);
		app.quit();
	}
}
