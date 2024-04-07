package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void ClickonSearchbar() {
		Searchbar.click();
	}
	public void ClearonSearchbar() {
		Searchbar.clear();
	}
	public void SendingCity(String city) {
		Searchbar.sendKeys(city);
	}
	public void SelectCity() throws InterruptedException {
		mywait.until(ExpectedConditions.elementToBeClickable(City));
		City.click();
	}
	public void SelectDoctors(int random) throws InterruptedException {
		//WebElement Specialist=Specialists.get(random);
		//mywait.until(ExpectedConditions.elementToBeClickable(Specialist));
		Thread.sleep(6000);
		Specialists.get(random).click();
		}
	
	
	

}
