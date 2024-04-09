package pageObjects;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;
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
	
	
	//Click on Surgery
	public void clickSurgery() {
		Surgery.click();
		js.executeScript("arguments[0].scrollIntoView();",popularsurgery);
	}
	
	//Capture list of surgeries
//	int m=0;
//	public void SurgeryList() {
//		for(WebElement Surgeries : SurgeryList) {
//			m++;
//			String Surgery=Surgeries.getText();
//			System.out.println(m+") "+Surgery);
//		}
		
	//	String[] arr = new String[SurgeryList.size()];
		public void Surgeries() throws IOException {
			String[] arr = new String[SurgeryList.size()];
			for(int i=0; i<SurgeryList.size(); i++) {
				arr[i]=SurgeryList.get(i).getText();
				ExcelUtility.write("Sheet1", 0, 4, "Surgeries");
				ExcelUtility.write("Sheet1", i+1, 4, arr[i]);
				
			}
			
		}
	
	//click on Forcorporates
	public void clickForcorporates() throws InterruptedException {
		System.out.println("Arun");
		
		Forcorporates.click();
		Thread.sleep(3000);

		
			Actions act = new Actions(driver);
			act.moveToElement(HealthPlan).perform();
		
		
			act.doubleClick(HealthPlan).perform();
	}
	
	//Send Name
	public void SendName(String name) throws InterruptedException, IOException {
		Thread.sleep(3000);
		ValidateName.sendKeys(name);
		ExcelUtility.write("Sheet1", 0, 5, "CandidateName");
		ExcelUtility.write("Sheet1", 1, 5, name);
		//System.out.println("Sent name");
	}
	
	//Send OrganizationName
	public void SendOrgName(String name) throws IOException {
		ValidateOrgName.sendKeys(name);
		ExcelUtility.write("Sheet1", 0, 6, "OrganizationName");
		ExcelUtility.write("Sheet1", 1, 6, name);
	}
	
	//Send Phone number
	public void SendPhnnum(String phn) throws IOException {
		ValidateNum.sendKeys(phn);
		ExcelUtility.write("Sheet1", 0, 7, "PhoneNum");
		ExcelUtility.write("Sheet1", 1, 7, phn);
	}
	
	//Send Invalid format MailId
	public void SendInvalidMail(String mail) throws IOException {
		ValidateMail.sendKeys(mail);
		ExcelUtility.write("Sheet1", 0, 8, "InvalidMailId");
		ExcelUtility.write("Sheet1", 1, 8, mail);
	}
	
	//Select required Organization Size
	public void SelectOrgSize(int i) {
		Select DrpOrgsize=new Select(OrgSize);
		DrpOrgsize.selectByIndex(i);
	}
	
	//Select field of interested in
	public void SelectInterestedIn(int i) {
		Select DropInterest=new Select(InterestedIn);
		DropInterest.selectByIndex(i);
	}
	
	//Check Schedule demo button is disable
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
	
	
	//Send valid Format Mail Id
	public void Sendvalidmail(String MailId) throws IOException {
		ValidateMail.clear();
		ValidateMail.sendKeys(MailId);
		ExcelUtility.write("Sheet1", 0, 9, "ValidMail");
		ExcelUtility.write("Sheet1", 1, 9, MailId);
	}
	
	//Check Schedule demo button is able
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
	
	//check Thank you msg
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
	
	
	

