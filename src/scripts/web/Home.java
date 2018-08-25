package scripts.web;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverCreation.Jira;
import driverCreation.TestBase;

public class Home extends TestBase {

	private final List<String>expectedMenus = Arrays.asList("ELECTRONICS","APPLIANCES","MEN","WOMEN","BABY & KIDS","HOME & FURNITURE","BOOKS & MORE","OFFER ZONE");
	private static Logger Log = Logger.getLogger(Home.class);
	
	
	@Test(description = "Verify Main Menu on HomePage")
	@Jira(id = "12346")
	public void verifyHomePageMainMenus() throws NoSuchElementException {
		Log.info("Verify Menu item");
		List<String> actualMenus = pageHelperFactory.getHomePage().getAllMainMenus();
		Assert.assertEquals(actualMenus, expectedMenus);
	}
	
	@Test(description = "Verify Menu Navigation")
	@Jira(id = "12347")
	public void goToMenu() throws NoSuchElementException {
		Log.info("Verify Menu Navigation");
		pageHelperFactory.getHomePage().goToMenu("Electronics","Samsung");
	}
}
