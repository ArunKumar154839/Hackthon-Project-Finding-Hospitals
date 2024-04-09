package stepdefinations;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CategoryPage;
import pageObjects.GooglePage;
import pageObjects.ProctoHomePage;
import pageObjects.Surgeriespage;
//import pageObjects.Validatingpage;

public class surgeriestest  {
	public WebDriver driver;
	Surgeriespage SP;
	ProctoHomePage PHP;
	GooglePage GP;
	CategoryPage CP;
	BaseClass bs;
	int randomnum;
	String generatedName;
	String Name;
	String Orgname;
	String generatedPhn;
	String Mail;
	//Validatingpage VP;
	Logger log = (Logger) bs.getLogger();
	@Given("the user navigates to the surgerylistpackage by clicking on the surgeries link")
	public void the_user_navigates_to_the_surgerylistpackage_by_clicking_on_the_surgeries_link() {
		log.info("*************Navigated to the surgery list package by clicking on the surgeries link***********");
		SP=new Surgeriespage(BaseClass.getDriver());
		SP.clickSurgery();
	}

	@When("the user stores all surgeries in a list")
	public void the_user_stores_all_surgeries_in_a_list() throws IOException {
		log.info("Storing all surgeries in a list");
	   SP.Surgeries();
	}
	@When("the user navigate to health and wealth Page")
	public void the_user_navigate_to_health_and_wealth_page() throws InterruptedException {
		log.info("^^^^^^^^^^Navigating to the health and wealth Page^^^^^^^^^^^^^");

	    SP.clickForcorporates();

	}
	@When("user give valid name")
	public void user_give_valid_name() throws InterruptedException, IOException {
		generatedName=RandomStringUtils.randomAlphabetic(5);
		Name=generatedName.toUpperCase();
		log.info("Valid name provided: " + Name);
		SP.SendName(Name);
	}

	@When("user give valid Organization name")
	public void user_give_valid_organization_name() throws IOException {
		generatedName=RandomStringUtils.randomAlphabetic(5);
		Orgname=generatedName.toUpperCase();
		log.info("Valid organization name provided: " + Orgname);
		SP.SendOrgName(Orgname);
	}

	@When("user give Valid PhoneNumber")
	public void user_give_valid_phone_number() throws IOException {
		while(true){
			generatedPhn=RandomStringUtils.randomNumeric(10);
			 char firstChar = generatedPhn.charAt(0);
			 if(firstChar == '6' || firstChar == '7' || firstChar == '8' || firstChar == '9') {
				 break;
			 }
			
		}
		log.info("Valid phone number provided: " + generatedPhn);
		SP.SendPhnnum(generatedPhn);
	}

	@When("user give Invalid MailId")
	public void user_give_invalid_mail_id() throws IOException {
		String Str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(3);
		Mail=Str+num+"@.com";
		log.info("Invalid EmailId provided: " + Mail);
		SP.SendInvalidMail(Mail);
	}

	@When("user select required Oraganization Size")
	public void user_select_required_oraganization_size() {
		while(true) {
			String generatedString=RandomStringUtils.randomNumeric(1);
			randomnum=Integer.parseInt(generatedString);
			if(randomnum>=1 && randomnum<=5) {
				break;
			}
		}
		log.info("Reqired Organization got selected");
		SP.SelectOrgSize(randomnum);
	}

	@When("user select Interested In")
	public void user_select_interested_in() {
		while(true) {
			String generatedString=RandomStringUtils.randomNumeric(1);
			randomnum=Integer.parseInt(generatedString);
			if(randomnum>=1 && randomnum<=4) {
				break;
			}
		}
		log.info("User selected interested criteria");
		SP.SelectInterestedIn(randomnum);
	}

	@When("user Validate Schedule a demo button is disable")
	public void user_validate_schedule_a_demo_button_is_disable() throws InterruptedException {
		log.info("Schedule button is diabled");
		SP.ScheduleButtondisable();
	}
	@When("user give valid MailId")
	public void user_give_valid_mail_id() throws IOException {
		String Str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(3);
		String Mail=Str+num+"@gmail.com";
		log.info("valid EmailId provided: " + Mail);
		SP.Sendvalidmail(Mail);
	}
	@When("user Validate Schedule a demo button is able")
	public void user_validate_schedule_a_demo_button_is_able() throws InterruptedException {
		log.info("Validated Schedule button is able");
	   SP.ValidateSchedulebutton();
	}
	@Then("ThankYou Message is displayed")
	public void thank_you_message_is_displayed() {
		log.info("Thank you message got displayed");
	   SP.ValidateThankyou();
	}




}
