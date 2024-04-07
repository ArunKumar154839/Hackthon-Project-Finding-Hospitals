package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class windowHandlespage extends BasePage{
	String originalwindow;
	public windowHandlespage(WebDriver driver) {
		super(driver);
	}
	public void WindowHandle() {
		originalwindow=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
	}
	public void oldWindow() {
		driver.close();
		driver.switchTo().window(originalwindow);
	}

}
