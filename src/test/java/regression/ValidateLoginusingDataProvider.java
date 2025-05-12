package regression;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginusingDataProvider extends BaseTest{
	
	@Test(dataProvider="getObjects")
	public void validateLogin(String username,String pwd, String expTitle)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		assertEquals(driver.getTitle(), expTitle);
	}

	@DataProvider
	public Object[][] getObjects() 
	{
		Object[][] data= new Object[4][3];
		
		data[0][0]="Sashikumar";
		data[0][1]="Sashikumar@47";
		data[0][2]="Adactin.com - Search Hotel";
		
		data[1][0]="Sashikumar";
		data[1][1]="Sashikumar@475364";
		data[1][2]="Adactin.com - Hotel Reservation System";
		
		data[2][0]="Sashikumar231445";
		data[2][1]="Sashikumar@47";
		data[2][2]="Adactin.com - Hotel Reservation System";
		
		data[3][0]="Sashikumar453";
		data[3][1]="Sashikumar@47243";
		data[3][2]="Adactin.com - Hotel Reservation System";
		
		return data;
	}
	
}
