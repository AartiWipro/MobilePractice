package extentReports;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Aarti
 *
 */
public class ExtentReportNG implements IReporter {
	private ExtentReports extent;
	ExtentHtmlReporter htmlReporter;

	/**
	 * @param <XmlSuite>
	 * @param XmlSuite
	 * @param suites
	 * @param outputDirectory
	 */
	   @Override
	   public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "\\htmlReports\\result.html"));		
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestModes(context.getPassedTests(), Status.PASS);
				buildTestModes(context.getPassedTests(), Status.FAIL);
				buildTestModes(context.getPassedTests(), Status.SKIP);
			}
		}
		extent.flush();
	}

	/**
	 * @param tests
	 * @param status
	 */
	private void buildTestModes(IResultMap tests, Status status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";
				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();
				test.log(status, message);
			}
		}
	}
}
