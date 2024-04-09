package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class windowHandlespage extends BasePage{
	String originalwindow;
	
	public windowHandlespage(WebDriver driver) {
		super(driver);
	}
	
	//WindowHandle to switch to new window
	public void WindowHandle() {
		originalwindow=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	//Closing new Window and return to old Window
	public void oldWindow() {
		driver.close();
		driver.switchTo().window(originalwindow);
	}

}
