package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;

public class Listeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String sc = result.getName();
		System.out.print("-----" + sc);
		try {
			Base.GetScreenShot(sc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
