package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;

public class ProctoHomePage extends BasePage {
	
	public ProctoHomePage(WebDriver driver){
		super(driver);
	}
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//Locators
	
	@FindBy(xpath="//input[@placeholder='Search location']")WebElement Searchbar;
	@FindBy(xpath="//div[@class='c-omni-suggestion-group']/div/div")WebElement City;
	@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")WebElement SpecilistSearchbar;
	@FindBy(xpath="//div[@class='c-omni-suggestion-item']")List<WebElement>Specialists;
	
	//click on Searchbar
	public void ClickonSearchbar() {
		Searchbar.click();
	}
	
	//clear on search bar
	public void ClearonSearchbar() {
		Searchbar.clear();
	}
	
	//Send random city 
	public void SendingCity(String city) throws IOException {
		Searchbar.sendKeys(city);
		ExcelUtility.write("Sheet1", 0, 0, "City");
		ExcelUtility.write("Sheet1", 1, 0, city);
	}
	
	//Select required city
	public void SelectCity() throws InterruptedException {
		mywait.until(ExpectedConditions.elementToBeClickable(City));
		City.click();
	}
	
	//Select required Specialist
	public void SelectDoctors(int random) throws InterruptedException, IOException {
		//WebElement Specialist=Specialists.get(random);
		//mywait.until(ExpectedConditions.elementToBeClickable(Specialist));
		Thread.sleep(6000);
		String Specialist=Specialists.get(random).getText();
		Specialists.get(random).click();
//		try {
			ExcelUtility.write("Sheet1", 0, 1, "Specialist");
			ExcelUtility.write("Sheet1", 1, 1, Specialist);
//		
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
	
	
	

}
}
