package driverCreation;

import businessLogic.mobilepages.MobileLoginPage;
import businessLogic.webpages.HomePage;
import businessLogic.webpages.LoginPage;

public class PageHelperFactory  {
	private HomePage homepage;
	private LoginPage loginpage;
	private MobileLoginPage mobileloginpage;

	public PageHelperFactory() {		
		homepage = new HomePage();
		loginpage = new LoginPage();
		mobileloginpage = new MobileLoginPage();
	}

	public HomePage getHomePage() {
		return this.homepage;
	}

	public LoginPage getLoginPage() {
		return this.loginpage;
	}
	
	public MobileLoginPage getMobileLoginPage() {
		return this.mobileloginpage;
	}
}
