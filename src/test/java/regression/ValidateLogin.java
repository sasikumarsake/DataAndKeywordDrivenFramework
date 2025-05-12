package regression;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLogin extends BaseTest{
	
	@Test(description="To Validate login using valid credentials.." )
	public void validateLoginTest1()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sashikumar");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sashikumar@47");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
	}

	@Test(description="To Validate login using valid username and invalid pwd.." )
	public void validateLoginTest2()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sashikumar");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sashikumar@1234546");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String expectedValue = "Invalid Login details or Your Password might have expired. Click here to reset your password";
		WebElement actualValue=driver.findElement(By.xpath("//div[@class='auth_error']/child::b"));
		
		assertEquals(actualValue.getText(), expectedValue);
		
		//assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
	}

	@Test(description="To Validate login using invalid username and valid pwd.." )
	public void validateLoginTest3()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sashikumar342356");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sashikumar@47");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@Test(description="To Validate login using invalid username and invalid pwd.." )
	public void validateLoginTest4()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sashikumar342356");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sashikumar@4779878");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
}
