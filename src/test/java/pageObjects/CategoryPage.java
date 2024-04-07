package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(xpath="//div[@class='listing-doctor-card']//div[@class='info-section']")List<WebElement>DoctorsList;
	@FindBy(xpath="//div[text()='Surgeries']")WebElement Surgery;
	public void ClickExperience() {
		mywait.until(ExpectedConditions.elementToBeClickable(Experience));
		Experience.click();
		
	}
	public void SelectExperience(int random) throws InterruptedException {
		WebElement experience=Selectexperience.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(experience));
		experience.click();
		
		
	}
	public void ClickAllfilters() {
		mywait.until(ExpectedConditions.elementToBeClickable(Allfilters));
		Allfilters.click();
	}
	public void SelectFee(int random) throws InterruptedException {
		WebElement fee=FeeList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(fee));
		fee.click();
		System.out.println(fee.getText());
	}
	public void Availability(int random) throws InterruptedException {
		//WebElement availabilty=AvailabilityList.get(random);
		ClickAllfilters();
		WebElement availabilty=AvailabilityList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(availabilty));
		availabilty.click();
			System.out.println(availabilty.getText());
	
	}
	public void SortByclick() {
		mywait.until(ExpectedConditions.elementToBeClickable(SortBy));
		SortBy.click();
	}
	public void SelectSort(int random) throws InterruptedException {
		WebElement sort=SortByList.get(random);
		mywait.until(ExpectedConditions.elementToBeClickable(sort));
		sort.click();
	}
	int m=0;
	int doctors=DoctorsList.size();
	public void DoctorsList() {
		if(doctors>=5) {
			for(WebElement doctor : DoctorsList) {
				m++;
				String availableDoctors=doctor.getText();
				System.out.println(m+") "+availableDoctors);
				System.out.println();
				if(m==5) {
					break;
				}
		}
		}
			else {
				for(WebElement doctor : DoctorsList) {
					m++;
					String availableDoctors=doctor.getText();
					System.out.println(m+") "+availableDoctors);
					System.out.println();
				}
			}
			
		}
	public void clickSurgery() {
		Surgery.click();
	}
	}

