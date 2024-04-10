package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class GooglePage extends BasePage{
	int J=0;
	int generatednum;
	public GooglePage(WebDriver driver) {
		super(driver);
		driver.get("https://journeyz.co/top-10-biggest-cities-in-india/");
	}
	//Locators
	@FindBy(xpath="//td[@class='column-2']") List<WebElement> Cities;//list of cities get from google
	
	//Get random Number
	
	
	//Get random Number
	public int randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(1);
		generatednum=Integer.parseInt(generatedString);
		return generatednum;
	}
	
	
	//get cities randomly 
	public String gettingCities() {
		String city=Cities.get(generatednum).getText();
		return city;
	}
	String[] arr = new String[10];
	public void cities() throws IOException {
		for(int i=0; i<Cities.size(); i++) {
			arr[i]=Cities.get(i).getText();
//			ExcelUtility.write("Sheet1", 0, 0, "Cities");
//			ExcelUtility.write("Sheet1", i+1, 0, arr[i]);
			
		}
		
	}

}
