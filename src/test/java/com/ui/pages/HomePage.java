package com.ui.pages;

import org.openqa.selenium.By;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[@class='login']");

	public HomePage(Browser browserName) {
		super(browserName);// To call the parent class constructor from child class constructor
		goToWebsite(JsonUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() { // Page Functions
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
