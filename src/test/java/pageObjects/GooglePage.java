package pageObjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage{
	int generatednum;
	public GooglePage(WebDriver driver) {
		super(driver);
		driver.get("https://journeyz.co/top-10-biggest-cities-in-india/");
	}
	//Locators
	@FindBy(xpath="//td[@class='column-2']") List<WebElement> Cities;
	public int randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(1);
		generatednum=Integer.parseInt(generatedString);
		return generatednum;
	}
	public String gettingCities() {
		String city=Cities.get(generatednum).getText();
		return city;
	}

}
