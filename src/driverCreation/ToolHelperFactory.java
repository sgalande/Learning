package driverCreation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class ToolHelperFactory {
	 static ThreadLocal<ToolHelperFactory> toolHelperFactory = new ThreadLocal<ToolHelperFactory>();
	
	public static ToolHelperFactory getdriver() {
		return toolHelperFactory.get();
	}
	
	public static void init(String browser) {
		toolHelperFactory.set(new WebElementLocator(browser));
	}
	
	public abstract WebElement findElement(By by); 
	public abstract void swipe(int startx,int starty,int endx,int endy,int duration);
	public abstract boolean waitForElement(By by);
	public abstract void moveToElement(WebElement element);
	public abstract List<WebElement> findElements(By by);
	public abstract String captureScreenshot(String screenshotName);
	public abstract void quit();
	public abstract void get(String url);
}
