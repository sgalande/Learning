package driverCreation;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {
	static Logger log = Logger.getLogger(TestBase.class);
	public PageHelperFactory pageHelperFactory;
	protected static  ThreadLocal<ExtentReports> extent = new ThreadLocal<ExtentReports>();
	protected static ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
	public String userDirectory = System.getProperty("user.dir");
	
	
	
	public synchronized static ExtentReports getExtentReport() {
		return extent.get();
	}
	
	public synchronized static ExtentTest getLogger() {
      return logger.get();
  }
		
	@BeforeSuite(alwaysRun=true)
	public void getdriver() {
		log.info("****Configure Log4j property");
		String log4jConfigFile = userDirectory+"/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile); 
	}
	
	@Parameters({"browser"})
	@BeforeTest (alwaysRun=true)
	public void beforeTestSetUp(String browser) {	
		extent.set(new ExtentReports(userDirectory+"/reports/"+browser+".html", true));
		getExtentReport().loadConfig(new File(userDirectory+"/extent-config.xml"));
		ToolHelperFactory.init(browser);
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeTestBaseClass() {
		pageHelperFactory = new PageHelperFactory();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUpBeforeBaseMethod() {
		log.info("****************Opening Flipkart*****************");
		ToolHelperFactory.getdriver().get("http://www.flipkart.com");
		if(ToolHelperFactory.getdriver().waitForElement(By.cssSelector("button._2AkmmA._29YdH8"))) {
			ToolHelperFactory.getdriver().findElement(By.cssSelector("button._2AkmmA._29YdH8")).click();
		}
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		getExtentReport().flush();
		ToolHelperFactory.getdriver().quit();
	}
}
