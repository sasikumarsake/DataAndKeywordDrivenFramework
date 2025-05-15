package smoke;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateRegistrationusindDataDriven extends BaseTest {

	@Test(dataProvider = "getTestData")
	public void validateRegistrationTest(HashMap<String, String> testdata) {
		ApplicationKeywords app = new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.click("newUserRegister_linktext");
		app.verifyTitle(testdata.get("expTitle"));
		app.type("newRegitrationUsername_textbox", testdata.get("username"));
		app.type("newRegitrationPassword_textbox", testdata.get("password"));
		app.type("newRegitrationConfirmPassword_textbox", testdata.get("ConfirmPassword"));
		app.type("newRegitrationFullName_textbox", testdata.get("FullName"));
		app.type("newRegitrationEmailAddress_textbox", testdata.get("EmailAddress"));
		app.type("newRegitrationCaptcha_textbox",testdata.get("catcha"));
		app.click("newRegitrationTerms/Conditions_textbox");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		
		Object [][] data=new Object[1][1];
		
		 data[0][0]=UtilKit.getTestDataFromExcel("TC-003");
		
		
		return data;
		
	}
}
