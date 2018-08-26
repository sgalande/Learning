package driverCreation;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebElementLocator extends ToolHelperFactory {

	private WebDriver driver;
	private WebDriverWait wait;
	static Logger log = Logger.getLogger(WebElementLocator.class);

	public String userDirectory = System.getProperty("user.dir");
	
	public WebElementLocator(String browser) {
	
		if(browser.equalsIgnoreCase("Chrome")) {
        	log.info("*************Setting Chrome Path****************");
    		System.setProperty("webdriver.chrome.driver",userDirectory+"/drivers/chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		wait = new WebDriverWait(driver, 30);
    		
        } else if (browser.equalsIgnoreCase("Firefox")) {
        	log.info("*************Setting Firefox Path****************");
    		System.setProperty("webdriver.gecko.driver",userDirectory+"/drivers/geckodriver.exe");
    		driver = new FirefoxDriver();
    		driver.manage().window().maximize();
    		wait = new WebDriverWait(driver, 30);
		} else if (browser.equalsIgnoreCase("IE")) {
        	log.info("*************Setting Firefox Path****************");
    		System.setProperty("webdriver.ie.driver",userDirectory+"/drivers/MicrosoftWebDriver.exe");
    		driver = new InternetExplorerDriver();
    		driver.manage().window().maximize();
    		wait = new WebDriverWait(driver, 30);
		} 
        
        else if (browser.equals("Android")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("Android");
			capabilities.setVersion("6.0.1");
			capabilities.setPlatform(Platform.ANDROID);
			capabilities.setCapability("appPackage", "com.flipkart.android");
			capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
			capabilities.setCapability("deviceName", "5203b831ecbf836b");
			try {
				driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public WebElement findElement(By by) 
			 {
		String visibility = "true";
		WebElement element = null;

		int waitTime = 30;
		for (int i = 1; i <= waitTime; i++) {
			try {
				element = driver.findElement(by);
				if (element != null) {
					break;
				}
			} catch (NoSuchElementException e) {
				if (visibility == "false") {
					break;
				} 
			}
		}
		
		return element;
	}

	public boolean waitForElement(By by) {

		String visibility = "true";
		WebElement element = findElement(by);

		if (visibility == "true") {
			if (element != null) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return true;
			}
		} else if (visibility == "false") {
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
		}
		return false;
	}

	
	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	@Override
	public List<WebElement> findElements(By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public String captureScreenshot(String screenshotName) {
		log.info("Capturing Screenshot");
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH-mm-ss");
		screenshotName += dateFormat.format(date);
		String destination = userDirectory+"/Screenshot/"
				+ screenshotName + ".png";
		try {
			FileUtils.copyFile(scr, new File(destination));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destination;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void swipe(int startx, int starty, int endx, int endy,int duration) {
		Dimension size = driver.manage().window().getSize();
		  System.out.println(size);
		  starty = (int) (size.height * 0.50);
		  endy = (int) (size.height * 0.20);
		  startx = size.width / 2;
        new TouchAction((MobileDriver<WebElement>) driver).press(startx, starty).waitAction(Duration.ofMillis(duration)).moveTo(endx, endy).release().perform();
	}

}
