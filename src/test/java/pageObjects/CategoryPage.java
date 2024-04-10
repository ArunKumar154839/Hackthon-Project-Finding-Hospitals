package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;

public class CategoryPage extends BasePage {
	public CategoryPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Locators
	@FindBy(xpath="//div[@class='c-filter__box u-pos-rel c-dropdown'][3]")WebElement Experience;
	@FindBy(xpath="//ul[@data-qa-id='years_of_experience_list']/li")List<WebElement> Selectexperience;
	@FindBy(xpath="//div[@class='u-d-inlineblock u-color--white u-c-pointer']")WebElement Allfilters;
	@FindBy(xpath="//div[@class='pure-u-4-24'][1]/div/label")List<WebElement>FeeList;
	@FindBy(xpath="//div[@class='pure-u-4-24'][2]/div/label")List<WebElement>AvailabilityList;
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")WebElement SortBy;
	@FindBy(xpath="//ul[@data-qa-id='sort_by_list']/li")List<WebElement> SortByList;
	@FindBy(xpath="//div[@class='listing-doctor-card']//div[@class='info-section']/a")List<WebElement>DoctorsList;
	@FindBy(xpath="//div[text()='Surgeries']")WebElement Surgery;
	
	
	//Click on Experience
	
	public void ClickExperience() {
		mywait.until(ExpectedConditions.elementToBeClickable(Experience));
		Experience.click();
		
	}
	//Select required Experience
	
	public void SelectExperience(int random) throws InterruptedException {
		WebElement experience=Selectexperience.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(experience));
		experience.click();
		
		
	}
	
	//Click All filters
	public void ClickAllfilters() throws InterruptedException {
		mywait.until(ExpectedConditions.elementToBeClickable(Allfilters));
		Allfilters.click();
	}
	
	//Select Fee
	public void SelectFee(int random) throws InterruptedException {
		WebElement fee=FeeList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(fee));
		fee.click();
		System.out.println(fee.getText());
	}
	
	//Select Availability
	public void Availability(int random) throws InterruptedException {
		//WebElement availabilty=AvailabilityList.get(random);
		Thread.sleep(3000);
		ClickAllfilters();
		WebElement availabilty=AvailabilityList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(availabilty));
		availabilty.click();
			System.out.println(availabilty.getText());
	
	}
	
	//Click on SortBy
	public void SortByclick() {
		mywait.until(ExpectedConditions.elementToBeClickable(SortBy));
		SortBy.click();
	}
	
	//Select Sorting option
	public void SelectSort(int random) throws InterruptedException {
		WebElement sort=SortByList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(sort));
		sort.click();
	}
	
	//Capturing top 5 doctor details
	int m=0;
	int doctors=DoctorsList.size();
	public void DoctorsList() throws IOException {
		if(doctors>=5) {
			String[] arr = new String[DoctorsList.size()];
			for(int i=0; i<5; i++) {
				arr[i]=DoctorsList.get(i).getText();
				ExcelUtility.write("Sheet1", 0, 2, "Doctors");
				ExcelUtility.write("Sheet1", i+1, 2, arr[i]);
				
			}
//			for(WebElement doctor : DoctorsList) {
//				m++;
//				String availableDoctors=doctor.getText();
//				System.out.println(m+") "+availableDoctors);
//				System.out.println();
//				if(m==5) {
//					break;
//				}
//		}
		}
			else {
//				for(WebElement doctor : DoctorsList) {
//					m++;
//					String availableDoctors=doctor.getText();
//					System.out.println(m+") "+availableDoctors);
//					System.out.println();
//				}
				String[] arr = new String[DoctorsList.size()];
				for(int i=0; i<DoctorsList.size(); i++) {
					arr[i]=DoctorsList.get(i).getText();
					ExcelUtility.write("Sheet1", 0, 2, "Doctors");
					ExcelUtility.write("Sheet1", i+1, 2, arr[i]);
			}
			
		}
	}
	
	//click on Surgery
	public void clickSurgery() {
		Surgery.click();
	}
	}

