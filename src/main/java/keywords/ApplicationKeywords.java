package keywords;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationKeywords extends ValidationKeywords{
	
	GenericConstants constant = new GenericConstants();
	
	public ApplicationKeywords() {
		String path  = System.getProperty("user.dir")+"//src//test//resources//locators.properties";
		prop = new Properties();
		envProp = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
			String env=prop.getProperty("env")+".properties";
			path  = System.getProperty("user.dir")+"//src//test//resources//"+env;
			fs = new FileInputStream(path);
			envProp.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void defaultLogin() throws InterruptedException {
		openBrowser(constant.Chrome);
		navigate(constant.url);
		Thread.sleep(5000);
		click(constant.userIcon_id);
		type(constant.loginUsername_xpath, "apurwa");
		type(constant.loginPassword_xpath, "Pass1");
		click(constant.signIn_id);
		waitForPageToLoad();
	}
}