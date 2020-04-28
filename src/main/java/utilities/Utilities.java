package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
	static AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		Utilities.driver = driver;
	}

	public WebElement ScrollToText(String Country) {
		WebElement ele = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + Country + "\").instance(0))"));
		//WebElement ele = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + Country + "\"));");
	return ele; 
	}
	
	public static void Click(WebElement ele) throws InterruptedException {
		ele.click();
		Thread.sleep(4000);
	}
	
	public static void GetPropertiesValue(String value) throws IOException
	{
	FileInputStream fs = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\globle.properties");
	Properties prop = new Properties();
	prop.load(fs);
	prop.get(value);
	}
}
