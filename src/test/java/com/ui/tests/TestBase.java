package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homepage; // This can be used in child classes as well
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	private boolean isHeadless;

	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the Home Page of Website")
	public void setup(@Optional("chrome")String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true")boolean isHeadless,ITestResult result) {
		
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.intializeLambdaTestSesstion("chrome", result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver);
		} else {
			homepage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homepage;
	}
	
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
		}
	}

}
