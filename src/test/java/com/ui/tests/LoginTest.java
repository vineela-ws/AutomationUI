package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
			"sanity" },dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider",
					retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
					
	public void loginTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
				"Vineela Amaraneni");
	}

}
