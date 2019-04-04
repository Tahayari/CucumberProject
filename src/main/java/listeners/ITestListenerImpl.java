package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerImpl extends ExtentReportsListener	 implements ITestListener  {
	
	private static ExtentReports extent;
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASSED");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIPPED");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {
		System.out.println("Execution of tests started...");
		extent = setUp();
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution of tests has ended...");
		extent.flush();
		System.out.println("Generated Report...");
	}

}
