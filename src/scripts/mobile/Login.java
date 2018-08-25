package scripts.mobile;

import org.testng.annotations.Test;

import driverCreation.Jira;
import driverCreation.TestBase;

public class Login extends TestBase {

	@Test(description = "Verify Main Menu on HomePage")
	@Jira(id = "12346")
	public void loginWithInvalidPassword(){

		pageHelperFactory.getMobileLoginPage().doLogin("sunny.galande@gmail.com","swapnil555");
		
	}
}
