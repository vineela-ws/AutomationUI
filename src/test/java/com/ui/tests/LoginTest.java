package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest {

	public static void main(String[] args) {
		HomePage homepage = new HomePage(CHROME);
		//LoginPage loginpage = homepage.goToLoginPage();	
		//loginpage.doLoginWith("goceno2705@kimasoft.com","Password");
		String userName = homepage.goToLoginPage().doLoginWith("goceno2705@kimasoft.com","Password").getUserName();
		System.out.println(userName);
	}

}
