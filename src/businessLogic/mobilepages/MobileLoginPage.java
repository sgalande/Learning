package businessLogic.mobilepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import utility.Locator;
import businessLogic.webpages.LoginPage;
import driverCreation.ToolHelperFactory;

public class MobileLoginPage {

	
	private final String EMAIL_TEXTBOX = "com.flipkart.android:id/mobileNo";
	private final String PASSWORD_TEXTBOX = "com.flipkart.android:id/et_password";
	private final String LOGIN_BUTTON = "com.flipkart.android:id/btn_mlogin";
	private final String EXISTINGUSER_LINK = "com.flipkart.android:id/btn_mlogin";
	private static Logger Log = Logger.getLogger(LoginPage.class);
	
	
	public  void doLogin(String email, String password) {
		
		
		  
		ToolHelperFactory.getdriver().swipe(0, 0, 0, 0, 3000);
		 
		Log.info("***Clicking on existing user link***");
		clickExistingUserSignIn();
		
		Log.info("***Enter Email Address***");
		enterEmailAddress(email);
		
		Log.info("***Enter Password***");
		enterPassword(password);
		
		Log.info("***Click On Login Button***");
		clickLoginButton();
	}
	
	public void enterEmailAddress(String emailAddress) {
		Log.info("*** Finding for Email Address TextBox***");
		ToolHelperFactory.getdriver().findElement(Locator.byId(EMAIL_TEXTBOX)).sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		Log.info("*** Finding for Password  TextBox***");
		ToolHelperFactory.getdriver().findElement(Locator.byId(PASSWORD_TEXTBOX)).sendKeys(password);;
	}
	
	public void clickLoginButton() {
		Log.info("***Finding for Login Button***");
		ToolHelperFactory.getdriver().findElement(Locator.byId(LOGIN_BUTTON)).click();;
	}
	
	public void clickExistingUserSignIn() {
		WebElement link = ToolHelperFactory.getdriver().findElement(Locator.byId(EXISTINGUSER_LINK));
		link.click();
	}	
}
