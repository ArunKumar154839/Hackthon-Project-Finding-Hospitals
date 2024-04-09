package stepdefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CategoryPage;
import pageObjects.GooglePage;
//import pageObjects.HomePage;
import pageObjects.ProctoHomePage;
import pageObjects.Surgeriespage;
//import pageObjects.Validatingpage;
import pageObjects.windowHandlespage;

public class SelectingLocation {
	
	public WebDriver driver;
	ProctoHomePage PHP;
	GooglePage GP;
	CategoryPage CP;
	Surgeriespage SP;
	windowHandlespage WP;
	BaseClass bs;
	
	String originalwindow;
	String City;
	int random;
	Logger log=(Logger) bs.getLogger();
	//List<HashMap<String, String>> datamap;
	@Given("the user navigate PractoHomePage")
	public void the_user_navigate_practo_home_page() {
		
		log.info("**********************Navigated to Procto Home Page******************");
		PHP=new ProctoHomePage(BaseClass.getDriver());
		PHP.ClickonSearchbar();
	}

	@When("User Clear LocationSearchbar")
	public void user_clear_location_searchbar() {
		log.info("Cleared Location Search bar");
	    PHP.ClearonSearchbar();
	}

	@When("User Select required Location")
	public void user_select_required_location() throws IOException {
//		originalwindow=driver.getWindowHandle();
//		driver.switchTo().newWindow(WindowType.TAB);
		log.info("Window handled to open new window");
		WP=new windowHandlespage(BaseClass.getDriver());
		WP.WindowHandle();
	    GP=new GooglePage(BaseClass.getDriver());
	    GP.randomeNumber();
	    City=GP.gettingCities();
	    //driver.close();
	    //driver.switchTo().window(originalwindow);
	    WP.oldWindow();
	    log.info("Required Location selected: " + City);
	    PHP.SendingCity(City);
	    try {
			PHP.SelectCity();
		}
		catch(Exception e) {
			 log.error("Error selecting city: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("Location is Selected and user sholud select Doctors")
	public void location_is_selected_and_user_sholud_select_doctors() throws IOException {
		while(true) {
			//GP=new GooglePage(BaseClass.getDriver());
			random= GP.randomeNumber();
			if(random<7) {
				break;
			}
		}
		//System.out.println(random);
		try {
			log.info("Required Specialist got selected");
			PHP.SelectDoctors(random);

		}
		catch(Exception e) {
			log.error("Error selecting doctors: " + e.getMessage());
			e.printStackTrace();
		}
		GP.cities();
	}
	@When("user should navigate to Category page")
	public void user_should_navigate_to_category_page() {
	    CP=new CategoryPage(BaseClass.getDriver());
	}
	@When("the user selects the Experience filter")
	public void the_user_selects_the_experience_filter() {
		log.info("Clicked on Experience");
	    CP.ClickExperience();
	    while(true) {
	    	random=GP.randomeNumber();
	    	if(random<4) {
	    		break;
	    	}
	    }
	    try {
	    	log.info("Required Experice for specialist got selected");
	    	CP.SelectExperience(random);
	    }
	    catch(Exception e) {
	    	log.error("Error selecting experience: " + e.getMessage());
	    	e.printStackTrace();
	    }
		
	}

	@When("the user clicks on All filters")
	public void the_user_clicks_on_all_filters() throws InterruptedException {
		log.info("All Filters got selected");
	   CP.ClickAllfilters();
	}

	@When("the user selects the Fees filter")
	public void the_user_selects_the_fees_filter() {
		while(true) {
	    	random=GP.randomeNumber();
	    	if(random<4) {
	    		break;
	    	}
	    }
	    try {
	    	log.info("Required Fee got selected");
	    	CP.SelectFee(random);
	    }
	    catch(Exception e) {
	    	log.error("Error selecting fees: " + e.getMessage());
	    	e.printStackTrace();
	    }
	    
	}

	@When("the user selects the Availability filter")
	public void the_user_selects_the_availability_filter() {
		while(true) {
	    	random=GP.randomeNumber();
	    	if(random<4) {
	    		break;
	    	}
	    }
	    try {
	    	log.info("Availability time of Specialist got selected");
	    	CP.Availability(random);
	    }
	    catch(Exception e) {
	    	log.error("Error selecting availability: " + e.getMessage());
	    	e.printStackTrace();
	    }
	}

	@When("the user selects one sorting option")
	public void the_user_selects_one_sorting_option() {
		log.info("Clicked on SortBy");
	    CP.SortByclick();
	    while(true) {
	    	random=GP.randomeNumber();
	    	if(random<4) {
	    		break;
	    	}
	    }
	    try {
	    	log.info("Required SortBy got selected");
	    	CP.SelectSort(random);
	    }
	    catch(Exception e) {
	    	log.error("Error selecting sorting option: " + e.getMessage());
	    	e.printStackTrace();
	    }
	}
	@Then("the user capture first  details")
	public void the_user_capture_first_details() throws IOException {
		log.info("Availability of Doctors list Displayed");
	    CP.DoctorsList();
	   // CP.clickSurgery();
	}
//	@When("the user navigates to the surgerylistpackage by clicking on the surgeries link")
//	public void the_user_navigates_to_the_surgerylistpackage_by_clicking_on_the_surgeries_link() {
//		SP=new Surgeriespage(driver);
//		SP.clickSurgery();
//	}
//
//	@When("the user stores all surgeries in a list")
//	public void the_user_stores_all_surgeries_in_a_list() {
//	   SP.SurgeryList();
//	}
//	@When("the user navigate to health and wealth Page")
//	public void the_user_navigate_to_health_and_wealth_page() {
//	    VP=new Validatingpage(driver);
//	    VP.clickForcorporates();
//	    VP.clickHealthplan();
//	}
	


	
	








	
		
}


