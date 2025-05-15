package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import exceptions.InvalidBrowserException;

public class BaseTest {

	public static WebDriver driver;

	public static FileInputStream fis1;
	public static Properties configProp;
	
	public static FileInputStream fis2;
	public static Properties locatorsProp;

	@BeforeTest
	public void beforeTest() {
		try {
			fis1 = new FileInputStream("Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		configProp = new Properties();
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis2 = new FileInputStream("Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		locatorsProp = new Properties();
		try {
			locatorsProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//@BeforeMethod
	public void setUp() {
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
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitwait"))));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
