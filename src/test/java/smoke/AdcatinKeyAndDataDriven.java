package smoke;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class AdcatinKeyAndDataDriven extends BaseTest {

	@Test(description = "To verify whether the check-out date field accepts a later date than check-in date.", dataProvider = "getTestData")
	public void AdactinTestcase2(HashMap<String, String> testdataMap) {
		ApplicationKeywords app = new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.type("username_textbox", testdataMap.get("username"));
		app.type("password_textbox", testdataMap.get("password"));
		app.click("login_button");
 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// app.click("location_textBox");
		app.selectItemFromDropDown("location_textBox", testdataMap.get("location"));
		app.selectItemFromDropDown("hotels_textBox", testdataMap.get("hotel"));
		app.selectItemFromDropDown("room_type_textBox", testdataMap.get("roomtype"));

		app.type("Check_In_Date_textBox", "18/05/2025");
		app.type("datepick_out_textBox", "15/05/2025");
		app.verifyTitle(testdataMap.get("expTitle"));
		app.click("click_Search");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestDataFromExcel("TC-005");

		return data;

	}

}
