package businessLogic.webpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import utility.Locator;
import driverCreation.ToolHelperFactory;

public class HomePage {

	private final String LOGIN_LINK = "Login & Signup";
	private final String EMAIL_TEXTBOX = "_2zrpKA";
	private final String PASSWORD_TEXTBOX = "input[type = 'password']";
	private final String LOGIN_BUTTON = "button[type='submit']";
	
	
	public void clickLoginLink() {
		ToolHelperFactory.getdriver().findElement(Locator.byLinkText(LOGIN_LINK)).click();
	}

	public  void doLogin(String email, String password) {
		clickLoginLink();
		enterEmailAddress(email);
		enterPassword(password);
		clickLoginButton();
	}

	public void enterEmailAddress(String emailAddress) {
		ToolHelperFactory.getdriver().findElement(Locator.byClassName(EMAIL_TEXTBOX)).sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		ToolHelperFactory.getdriver().findElement(Locator.byCssSelector(PASSWORD_TEXTBOX)).sendKeys(password);
	}

	public void clickLoginButton() {
		ToolHelperFactory.getdriver().findElement(Locator.byCssSelector(LOGIN_BUTTON)).click();
	}

	public void goToMenu(String ...strings) {
		WebElement menu = ToolHelperFactory.getdriver().findElement(Locator.byXpath("//span[text() = '"+strings[0]+"'"+"]"));
		ToolHelperFactory.getdriver().moveToElement(menu);
		ToolHelperFactory.getdriver().waitForElement(Locator.byXpath("//span[text() = '"+strings[1]+"'"+"]"));
		ToolHelperFactory.getdriver().findElement(Locator.byXpath("//span[text() = '"+strings[1]+"'"+"]")).click();		
	}

	public List<String> getAllMainMenus() {
		List<String>mainMenus = new ArrayList<String>();
		List<WebElement> list = ToolHelperFactory.getdriver().findElements(Locator.byCssSelector("li.Wbt_B2"));
		for (WebElement webElement : list) {
			mainMenus.add(webElement.getText());
		}
		return mainMenus;
	}
	
}
