package listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsListener {

	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;


	public static ExtentReports setUp(){
		String reportLocation = "./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Tet Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initialized...");
		report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "TR");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		return extent;		
	}

	public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable){
		switch (teststatus) {
		case "FAILED":
			extenttest.fail(MarkupHelper.createLabel("Test case is FAILED : ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());
			
			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (IOException e) {
				e.printStackTrace();
				}
			
			if (driver != null) {
				driver.quit();
			}
			break;

		case "PASSED":
			extenttest.pass(MarkupHelper.createLabel("Test case has PASSED : ", ExtentColor.GREEN));
			break;

		default: 
			break;
		}
	}
	
	public static String captureScreenShot(WebDriver driver) throws IOException{
		
		TakesScreenshot screen = (TakesScreenshot) driver ;
		File scr = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/screenshots/" + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileHandler.copy(scr, target);
		return dest;
		
	}

	private static String getcurrentdateandtime() {
		String str = null; 
		try{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");	
		} catch(Exception e){
			
		}
		
		return str;
	}
	
	
	
}
