 package smoke;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateRegistration extends BaseTest {

	@Test
	public void validateRegistrationTest() {
		ApplicationKeywords app = new ApplicationKeywords();
		app.startBrowser();
		app.launchApp();
		app.click("newUserRegister_linktext");
		app.verifyTitle("Adactin.com - New User Registration");
		app.type("newRegitrationUsername_textbox", "Kumar");
		app.type("newRegitrationPassword_textbox", "Kumar@1234");
		app.type("newRegitrationConfirmPassword_textbox", "Kumar@1234");
		app.type("newRegitrationFullName_textbox", "KumarSSk");
		app.type("newRegitrationEmailAddress_textbox", "Kumar@gmail.com");
		app.click("newRegitrationTerms/Conditions_textbox");
	}
}
