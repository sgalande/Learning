package businessLogic.mobilepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import businessLogic.webpages.LoginPage;
import driverCreation.ToolHelperFactory;

public class MobileLoginPage {

	
	private final By EMAIL_TEXTBOX = By.id("com.flipkart.android:id/mobileNo");
	private final By PASSWORD_TEXTBOX = By.id("com.flipkart.android:id/et_password");
	private final By LOGIN_BUTTON = By.id("com.flipkart.android:id/btn_mlogin");
	private final By EXISTINGUSER_LINK = By.id("com.flipkart.android:id/btn_mlogin");
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
		ToolHelperFactory.getdriver().findElement(EMAIL_TEXTBOX).sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		Log.info("*** Finding for Password  TextBox***");
		ToolHelperFactory.getdriver().findElement(PASSWORD_TEXTBOX).sendKeys(password);;
	}
	
	public void clickLoginButton() {
		Log.info("***Finding for Login Button***");
		ToolHelperFactory.getdriver().findElement(LOGIN_BUTTON).click();;
	}
	
	public void clickExistingUserSignIn() {
		WebElement link = ToolHelperFactory.getdriver().findElement(EXISTINGUSER_LINK);
		link.click();
	}	
}
