package assertions;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Aarti
 *
 */
public class Compare {
	static AndroidDriver<AndroidElement> driver;

	public Compare(AndroidDriver<AndroidElement> driver) {
		Compare.driver = driver;
	}

	/**
	 * @param ele
	 * @param expectedURL
	 * @return
	 */
	public boolean validatePageURL(WebElement ele, String expectedURL) {
		boolean result = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expectedURL)) {
			result = true;
		}
		return result;
	}

	/**
	 * @param ele
	 * @return
	 */
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

	/**
	 * @param ele
	 * @param text
	 * @return
	 */
	public static boolean validateText(WebElement ele, String text) {
		boolean result = false;		
			if (ele.getText().equals(text))
				result = true;
			else
				result = false;		
		return result;
	}

	/**
	 * @param exp
	 * @param act
	 * @return
	 */
	public static boolean assertEquals(String exp, String act) {
		boolean result = false;
		if (exp.contains(act))
			result = true;
		else
			result = false;
		return result;
	}

	/**
	 * @return
	 */
	public static boolean assertFail() {
		return false;
	}
}
