package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_LOCATOR = By.id("email");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By SUBMIT_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_LOCATOR, emailAddress);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(SUBMIT_LOCATOR);
		MyAccountPage myaccountpage = new MyAccountPage(getDriver());
		return myaccountpage;
	}

}
