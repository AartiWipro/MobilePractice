package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * @author Aarti
 *
 */
public class Base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	// Need Dependency slf4j :api, simple. commons : lang3, io, validator.
	/**
	 * @return
	 */
	public AppiumDriverLocalService StartServer() {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withLogFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\logResults.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		service.start();
		return service;
	}

	/**
	 * @param appName
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws InterruptedException, IOException {

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
		Properties prop = new Properties();
		prop.load(fs);
		File app = new File(System.getProperty("user.dir") + "\\app\\" + prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = (String) prop.get("device");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.mShop.android.shopping");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return driver;
	}

	/**
	 * @param sc
	 * @throws IOException
	 */
	public static void GetScreenShot(String sc) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\screenShots\\" + sc + ".png"));
	}

	public void closeDriver() {
		driver.quit();
	}
}
