package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LOCATOR = By.xpath("//a[@class='login']");
	
	public HomePage(Browser browserName) {
		super(browserName);// To call the parent class constructor from child class constructor
		goToWebsite("http://www.automationpractice.pl/index.php?");
	}

	public LoginPage goToLoginPage() {  //Page Functions
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
