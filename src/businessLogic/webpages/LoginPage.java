package businessLogic.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import driverCreation.ToolHelperFactory;

public class LoginPage {


	private final By EMAIL_TEXTBOX = By.className("_2zrpKA");
	private final By PASSWORD_TEXTBOX = By.cssSelector("input[type = 'password']");
	private final By LOGIN_BUTTON = By.cssSelector("button._2AkmmA._1LctnI._7UHT_c");
	private final By INVALID_LOGIN_ERROR_MESSAGE = By.cssSelector("span.ZAtlA-");
	
	private static Logger Log = Logger.getLogger(LoginPage.class);
	
	public  void doLogin(String email, String password) {
		
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
	
	public boolean verifyInvalidErrorMessage(String expectedErrrorMessage){
		
		Log.info("***Verifying Error Message***");
		String actualErrorMessage = ToolHelperFactory.getdriver().findElement(INVALID_LOGIN_ERROR_MESSAGE).getText();
		if(actualErrorMessage.equalsIgnoreCase(expectedErrrorMessage)) {
			return true;
		}
		return false;
	}
}
