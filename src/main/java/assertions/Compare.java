package assertions;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Compare {
	static AndroidDriver<AndroidElement> driver;

	public Compare(AndroidDriver<AndroidElement> driver) {
		Compare.driver = driver;
	}

	public boolean validatePageURL(WebElement ele, String expectedURL) {
		boolean result = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expectedURL)) {
			result = true;
		}
		return result;
	}

	public static boolean validateElement(WebElement ele) {
		boolean result = false;
		try {
			if (ele.isDisplayed())
				result = true;
			else
				result = false;
		} catch (Exception e) {
		}
		return result;
	}

	public static boolean validateText(WebElement ele, String text) {
		boolean result = false;
		try {
			if (ele.getText().equals(text))
				result = true;
			else
				result = false;
		} catch (Exception e) {
		}
		return result;
	}

	public static boolean assertEquals(String exp, String act) {
		boolean result = false;
		if (exp.contains(act))
			result = true;
		else
			result = false;
		return result;
	}


	public static boolean assertFail() {
		return false;
		
	}
}
