package businessLogic.webpages;

import org.apache.log4j.Logger;
import utility.Locator;
import driverCreation.ToolHelperFactory;

public class LoginPage {


	private final String EMAIL_TEXTBOX = "_2zrpKA";
	private final String PASSWORD_TEXTBOX = "input[type = 'password']";
	private final String LOGIN_BUTTON = "button._2AkmmA._1LctnI._7UHT_c";
	private final String INVALID_LOGIN_ERROR_MESSAGE = "span.ZAtlA-";
	
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
		ToolHelperFactory.getdriver().findElement(Locator.byClassName(EMAIL_TEXTBOX)).sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		Log.info("*** Finding for Password  TextBox***");
		ToolHelperFactory.getdriver().findElement(Locator.byCssSelector(PASSWORD_TEXTBOX)).sendKeys(password);;
	}
	
	public void clickLoginButton() {
		Log.info("***Finding for Login Button***");
		ToolHelperFactory.getdriver().findElement(Locator.byCssSelector(LOGIN_BUTTON)).click();;
	}
	
	public boolean verifyInvalidErrorMessage(String expectedErrrorMessage){
		
		Log.info("***Verifying Error Message***");
		String actualErrorMessage = ToolHelperFactory.getdriver().findElement(Locator.byCssSelector(INVALID_LOGIN_ERROR_MESSAGE)).getText();
		if(actualErrorMessage.equalsIgnoreCase(expectedErrrorMessage)) {
			return true;
		}
		return false;
	}
}
