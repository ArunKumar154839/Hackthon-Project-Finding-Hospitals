package pageObjects;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class Surgeriespage extends BasePage{
	
	public Surgeriespage(WebDriver driver) {
		super(driver);
	}
	//Locators
	JavascriptExecutor js=(JavascriptExecutor)driver;
	@FindBy(xpath="//div[text()='Surgeries']")WebElement Surgery;
	@FindBy(xpath="//p[@data-qa-id='surgical-solution-ailment-name']")List<WebElement>SurgeryList;
	@FindBy(xpath="//h1[@data-qa-id='surgical-solution-sub-header']")WebElement popularsurgery;
	@FindBy(xpath="//span[text()='For Corporates']")WebElement Forcorporates;
	
	@FindBy(xpath="//div[@class='u-d nav-dropdown text-left active-state']/div[1]/a")WebElement HealthPlan;
	@FindBy(xpath="//div[@id='app']/div/div/header/div[2]/div/form/div[1]/input")WebElement ValidateName;
	@FindBy(xpath="//*[@id='app']/div/div/header/div[2]/div/form/div[2]/input")WebElement ValidateOrgName;
	@FindBy(xpath="//*[@id='app']/div/div/header/div[2]/div/form/div[3]/input")WebElement ValidateNum;
	@FindBy(xpath="//*[@id='app']/div/div/header/div[2]/div/form/div[4]/input")WebElement ValidateMail;
	@FindBy(xpath="//*[@id='app']/div/div/header/div[2]/div/form/div[5]/select")WebElement OrgSize;
	@FindBy(xpath="//*[@id='app']/div/div/header/div[2]/div/form/div[6]/select")WebElement InterestedIn;
	@FindBy(xpath="//button[text()='Schedule a demo']")WebElement Schedulebutton;
	@FindBy(xpath="//div[text()='THANK YOU']")WebElement Thankyou;
	
	boolean invalidmail;
	boolean validmail;
	
	public void clickSurgery() {
		Surgery.click();
		js.executeScript("arguments[0].scrollIntoView();",popularsurgery);
	}
	int m=0;
	public void SurgeryList() {
		for(WebElement Surgeries : SurgeryList) {
			m++;
			String Surgery=Surgeries.getText();
			System.out.println(m+") "+Surgery);
		}
	}
	public void clickForcorporates() throws InterruptedException {
		System.out.println("Arun");
		
		Forcorporates.click();
		Thread.sleep(3000);

		
			Actions act = new Actions(driver);
			act.moveToElement(HealthPlan).perform();
		
		
			act.doubleClick(HealthPlan).perform();
	}
	public void SendName(String name) throws InterruptedException {
		Thread.sleep(3000);
		ValidateName.sendKeys(name);
		System.out.println("Sent name");
	}
	public void SendOrgName(String name) {
		ValidateOrgName.sendKeys(name);
	}
	public void SendPhnnum(String phn) {
		ValidateNum.sendKeys(phn);
	}
	public void SendInvalidMail(String mail) {
		ValidateMail.sendKeys(mail);
	}
	public void SelectOrgSize(int i) {
		Select DrpOrgsize=new Select(OrgSize);
		DrpOrgsize.selectByIndex(i);
	}
	public void SelectInterestedIn(int i) {
		Select DropInterest=new Select(InterestedIn);
		DropInterest.selectByIndex(i);
	}
	public void ScheduleButtondisable() {
		invalidmail=Schedulebutton.isEnabled();
		if(invalidmail==false) {
			System.out.println("Schedule Button is disable");
		}
		else {
			System.out.println("Schedule Button is able");
			Schedulebutton.click();
			System.out.println("Raise a bug");
			
		}
		
		}
	
	public void Sendvalidmail(String MailId) {
		ValidateMail.clear();
		ValidateMail.sendKeys(MailId);
	}
	public void ValidateSchedulebutton() throws InterruptedException {
		validmail=Schedulebutton.isEnabled();
		if(validmail==true) {
			System.out.println("Schedule Button is able");
			Schedulebutton.click();
		}
		else {
			System.out.println("Schedule Button is disable");
			System.out.println("Raise a bug");
			
		}
	}
	public void ValidateThankyou() {
		boolean validated=Thankyou.isDisplayed();
		if(validated==true) {
			System.out.println("Validation done succesfully");
		}
		else {
			System.out.println("Validation unsuccsful");
		}
	}
	
}
	
	
	

