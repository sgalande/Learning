package businessLogic.webpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import driverCreation.ToolHelperFactory;

public class HomePage {

	private final By LOGIN_LINK = By.linkText("Login & Signup");
	private final By EMAIL_TEXTBOX = By.className("_2zrpKA");
	private final By PASSWORD_TEXTBOX = By.cssSelector("input[type = 'password']");
	private final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
	
	
	public void clickLoginLink() {
		ToolHelperFactory.getdriver().findElement(LOGIN_LINK).click();
	}

	public  void doLogin(String email, String password) {
		clickLoginLink();
		enterEmailAddress(email);
		enterPassword(password);
		clickLoginButton();
	}

	public void enterEmailAddress(String emailAddress) {
		ToolHelperFactory.getdriver().findElement(EMAIL_TEXTBOX).sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		ToolHelperFactory.getdriver().findElement(PASSWORD_TEXTBOX).sendKeys(password);
	}

	public void clickLoginButton() {
		ToolHelperFactory.getdriver().findElement(LOGIN_BUTTON).click();
	}

	public void goToMenu(String ...strings) {
		WebElement menu = ToolHelperFactory.getdriver().findElement(By.xpath("//span[text() = '"+strings[0]+"'"+"]"));
		ToolHelperFactory.getdriver().moveToElement(menu);
		ToolHelperFactory.getdriver().moveToElement(ToolHelperFactory.getdriver().findElement(By.xpath("//span[text() = '"+strings[1]+"'"+"]")));		
	}

	public List<String> getAllMainMenus() {
		List<String>mainMenus = new ArrayList<String>();
		List<WebElement> list = ToolHelperFactory.getdriver().findElements(By.cssSelector("li.Wbt_B2"));
		for (WebElement webElement : list) {
			mainMenus.add(webElement.getText().toUpperCase());
		}
		return mainMenus;
	}
	
}
