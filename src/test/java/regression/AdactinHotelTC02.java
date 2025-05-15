package regression;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class AdactinHotelTC02 extends BaseTest{
	
	@Test(description="To validate login ",dataProvider="getTestData")
	public void validateLoginTest1(HashMap<String, String> testDataMap)
	{
		System.out.println(testDataMap.get("username"));
		System.out.println(testDataMap.get("password"));
		System.out.println(testDataMap.get("expTitle"));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testDataMap.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testDataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		assertEquals(driver.getTitle(), testDataMap.get("expTitle"));
		
			
	}
	
	
	@DataProvider

    public Object[][] getTestData() {
        return new Object[][] {
            { UtilKit.getTestDataFromExcel("TC-004") }
        };
}
}