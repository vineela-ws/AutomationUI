package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest {
	HomePage homepage;

	@BeforeMethod(description = "Load the Home Page of Website")
	public void setup() {
		homepage = new HomePage(CHROME);
	}

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
			"sanity" },dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider",
					retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
					
	public void loginTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
				"Vineela Amaraneni");
	}

}
