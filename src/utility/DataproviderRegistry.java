package utility;

import org.testng.annotations.DataProvider;

public class DataproviderRegistry {

	@DataProvider(name = "Authentication")
	public Object[][] Authentication() throws Exception{

		Object[][] testObjArray = ExcelUtils.getTabArray(System.getProperty("user.dir")+"/Resources/login.xlsx","Sheet1");
		return (testObjArray);
	}
}
