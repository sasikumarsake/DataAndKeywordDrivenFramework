package keywords;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import exceptions.InvalidBrowserException;

public class GenericKeywords extends BaseTest {

	public void startBrowser() {
		
		String browserName = configProp.getProperty("browser");

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();

			break;

		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "edge":
			driver = new EdgeDriver();

			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				System.out.println(e.getMessage());
			}

			break;
		}

	}
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
	
	}
	
	
	
	public void type(String locatorKey,String text)
	{
		//driver.findElement(By.xpath(locatorsProp.getProperty(locatorKey))).sendKeys(text);
		
		getElement(locatorKey).sendKeys(text);
	}
	
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
		
		
	}
	
	public void selectItemFromDropDown(String locatorKey,String visibleText)
	{
//		WebElement dropdownElement = getElement(locatorKey); // Assumes this resolves using the Object Repo
//	    Select select = new Select(dropdownElement);
//	    select.selectByVisibleText(visibleText); // e.g., "Sydney"
		new Select(getElement(locatorKey)).selectByVisibleText(visibleText);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}	
	private WebElement getElement(String locatorKey) {
		
		WebElement element=null;
		
		//Explicit Wait 
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProp.getProperty("explicitWait"))));
		
		myWait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		element=driver.findElement(getLocator(locatorKey));
		
		return element;
		
				
	}

	private By getLocator(String locatorKey) {
		
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linktext"))
		{
			by=By.linkText(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}
		else 
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}
		return by;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}