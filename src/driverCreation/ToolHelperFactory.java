package driverCreation;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

public abstract class ToolHelperFactory {
	 static ThreadLocal<ToolHelperFactory> toolHelperFactory = new ThreadLocal<ToolHelperFactory>();
	
	public static ToolHelperFactory getdriver() {
		return toolHelperFactory.get();
	}
	
	public static void init(String browser) {
		toolHelperFactory.set(new WebElementLocator(browser));
	}
	
	public abstract WebElement findElement(HashMap<String, String>params); 
	public abstract void swipe(int startx,int starty,int endx,int endy,int duration);
	public abstract boolean waitForElement(HashMap<String, String> params);
	public abstract void moveToElement(WebElement element);
	public abstract List<WebElement> findElements(HashMap<String, String>params);
	public abstract String captureScreenshot(String screenshotName);
	public abstract void quit();
	public abstract void get(String url);
}
