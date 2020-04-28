package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPanel {

	// Concatenate driver
	public SearchPanel(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text ='Settings']")
	public WebElement setting;
	@AndroidFindBy(xpath = "//*[@text ='Country & Language']")
	public WebElement countryLanguage;
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Country/Region:')]")
	public WebElement countryRegion;
	@AndroidFindBy(xpath = "//*[@text ='Australia Amazon.com.au']")
	public WebElement ausRedioBtn;

	public String GetCountryNameText(AppiumDriver driver) {
		String conRegValue = countryRegion.getText();
		return conRegValue;
	}
}