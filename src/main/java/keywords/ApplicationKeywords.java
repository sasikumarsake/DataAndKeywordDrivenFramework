package keywords;

public class ApplicationKeywords extends ValidationKeywords {

	public void loginWithDefaultData()
	{
		type("username_textbox", configProp.getProperty("username"));
		type("password_textbox", configProp.getProperty("password"));
		click("login_button");
	}
}
