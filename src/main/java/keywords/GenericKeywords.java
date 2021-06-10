package keywords;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords {
	public WebDriver driver;
	public Properties prop;
	public Properties envProp;

	public void openBrowser(String browserName) {
		log("Opening The Browser "+ browserName);
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
				driver = new ChromeDriver();
			}else if(browserName.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Common\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browserName.equals("Edge")) {
				System.setProperty("webdriver.edge.driver", "D:\\Common\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
	}
	
	public void navigate(String urlKey) {
		log("Navigating to "+ urlKey);
		driver.get(envProp.getProperty(urlKey));
		
	}
	
	public void click(String locatorKey) throws InterruptedException {
		log("Clicking on "+locatorKey);
		Thread.sleep(2000);
		getElement(locatorKey).click();
		
	}
	
	public void type(String locatorKey, String text) {
		log("Typing in "+locatorKey+" . Data "+ text);
		getElement(locatorKey).sendKeys(text);
	}
	
	public String getText(String locatorKey) {
		return getElement(locatorKey).getText();
	}
	
	public String generateRandomUsername() {
        String userName = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(6);
  
        for (int i = 0; i < 7; i++) {
            int index = (int)(userName.length()
                        * Math.random());
  
            sb.append(userName.charAt(index));
        }
  
        return sb.toString();
    }
	
	public void scrollDown(int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")");
		
	}
	
	public WebElement getElement(String locatorKey) {
		if(!isElementPresent(locatorKey)) {
			log("Element not present "+locatorKey);
		}
		if(!isElementVisible(locatorKey)) {
			log("Element not visible "+locatorKey);
		}
		WebElement e = driver.findElement(getLocator(locatorKey));
		
		return e;
	}

	public boolean isElementPresent(String locatorKey) {
		log("Checking presence of "+locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean isElementVisible(String locatorKey) {
		log("Checking visibility of " + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public By getLocator(String locatorKey) {
		By by=null;
		
		if(locatorKey.endsWith("_id"))
			by = By.id(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_xpath"))
			by = By.xpath(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_css"))
			by = By.cssSelector(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_name"))
			by = By.name(prop.getProperty(locatorKey));
		
		return by;	
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		log(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		i=0;
		while(i!=10){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(2);
			 i++;
				
			}	
		}
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quit() {
		driver.quit();
		
	}
}