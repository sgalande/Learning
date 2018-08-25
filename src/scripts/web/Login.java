package scripts.web;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.DataproviderRegistry;
import driverCreation.Jira;
import driverCreation.TestBase;

public class Login extends TestBase {

	@Test(description = "Verify Login with Invalid password",dataProviderClass = DataproviderRegistry.class,dataProvider = "Authentication")
	@Jira(id = {"12345","34343"})
	public void loginWithInvalidPassword(String username,String Password,String ErrorMessage) throws NoSuchElementException{

	pageHelperFactory.getHomePage().clickLoginLink();
		pageHelperFactory.getLoginPage().doLogin(username,Password);
		Assert.assertTrue(pageHelperFactory.getLoginPage().verifyInvalidErrorMessage(ErrorMessage));
	}
}
