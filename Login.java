package scripts.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;

import driverCreation.AndroidTestRailId;
import driverCreation.TestBase;

public class Login extends TestBase {

	@Test(description = "Verify Main Menu on HomePage")
	@AndroidTestRailId(id = { "12345", "34343" })
	public void loginWithInvalidPassword(){

		Assert.assertTrue(pageHelperFactory.getMobileLoginPage().verify_AllowButton());
		Assert.assertTrue(pageHelperFactory.getMobileLoginPage().verify_AllowButton());
		
	}
}
