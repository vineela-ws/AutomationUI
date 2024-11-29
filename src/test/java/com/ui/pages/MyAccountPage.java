package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	private static final By USER_NAME_LOCATOR = By.xpath("//*[@title='View my customer account']");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return visableText(USER_NAME_LOCATOR);
	}

}
