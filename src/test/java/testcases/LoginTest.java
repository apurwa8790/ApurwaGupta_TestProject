package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericConstants;
import keywords.GenericKeywords;
import keywords.ValidationKeywords;

public class LoginTest {
	
	ApplicationKeywords app = new ApplicationKeywords();
	GenericConstants constants = new GenericConstants();
	
	@Test
	public void loginSuccess() throws InterruptedException
	{
		app.defaultLogin();
		app.validateText(constants.loginSuccess_xpath, "apurwa");
		app.quit();
	}
	
	@Test
	public void logoutSuccess() throws InterruptedException {
		app.defaultLogin();
		app.click("userIcon_id");
		app.click("signOut_xpath");
		app.validateText("loginSuccess_xpath", "");
		app.quit();
	}
	
	@Test
	public void loginFailure() throws InterruptedException {
		app.openBrowser("Chrome");
		app.navigate("url");
		app.click("userIcon_id");
		app.type("loginUsername_xpath", "junk");
		app.type("loginPassword_xpath", "Pass1");
		app.click("signIn_id");
		app.validateText("invalidLoginErrorMessage_id", "Incorrect user name or password.");
		app.quit();
	}

}
