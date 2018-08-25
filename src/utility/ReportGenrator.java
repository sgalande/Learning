package utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import driverCreation.Jira;
import driverCreation.TestBase;
import driverCreation.ToolHelperFactory;

public class ReportGenrator extends TestBase implements ISuiteListener,ITestListener  {
	//static ExtentReports extent;
	//static ThreadLocal<ExtentTest> logger = new ThreadLocal<>();

//	public synchronized static ExtentTest getLogger() {
//        return logger.get();
//    }

	@Override
	public synchronized void onStart(ISuite suite) {
//		DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy HHmmss");
//		Date date = new Date();		
//		extent = new ExtentReports("C://AutomationWorkSpace//"+dateformat.format(date)+".html", true);
//		extent.loadConfig(new File("C://AutomationWorkSpace//Learning//extent-config.xml"));
	}

	@Override
	public synchronized void onFinish(ISuite suite) {
		//getExtentReport().flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		 Jira tag = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Jira.class);
		//logger.set(getExtentReport().startTest(result.getMethod().getDescription().split("-")[0]));
		 String[] var = tag.id();
		 logger.set(getExtentReport().startTest( String.join(",", var)));
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		
		getLogger().log(LogStatus.PASS, result.getMethod().getMethodName());
		getLogger().log(LogStatus.PASS,getLogger().addScreenCapture(ToolHelperFactory.getdriver().captureScreenshot(result.getName())));
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {

		getLogger().log(LogStatus.FAIL,"Test Case description::"+result.getMethod().getDescription());
		getLogger().log(LogStatus.FAIL, "Method Name :: "+result.getMethod().getMethodName());
		getLogger().log(LogStatus.FAIL, "Exception :: "+result.getThrowable());
		getLogger().log(LogStatus.FAIL, getLogger().addScreenCapture(ToolHelperFactory.getdriver().captureScreenshot(result.getName())));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Jira test = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Jira.class);
		getLogger().log(LogStatus.SKIP, test.id()[0]);
		getLogger().log(LogStatus.SKIP, result.getMethod().getMethodName());
		getLogger().log(LogStatus.SKIP,getLogger().addScreenCapture(ToolHelperFactory.getdriver().captureScreenshot(result.getName())));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		getExtentReport().endTest(getLogger());
	}

	
}
