package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import listeners.ExtentReportsListener;

import org.openqa.selenium.WebDriver;

import pageObjects.TRDashboard;
import pageObjects.TRLoginPage;
import utility.BrowserUtility;
import utility.PropertiesFileReader;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TRLoginStepDefs extends ExtentReportsListener  {
	private WebDriver driver;
	PropertiesFileReader obj= new PropertiesFileReader();  

	@Given("^Open browser and access TR page$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		ExtentTest logInfo = null;
		try {
			/*ExtentReport statement*/
			test = extent.createTest(Feature.class,"TR Login");
			test = test.createNode(Scenario.class,"Login with a valid username and pass in TR page");
			logInfo = test.createNode(new GherkinKeyword("Given"),"open_chrome_browser_and_enter_url");
			/*----------------------*/

			Properties properties=obj.getProperty();
			System.out.println(properties.getProperty("browser.name"));
			System.out.println(properties.getProperty("browser.baseURL")+"/tr/login");
			this.driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL")+"/tr/login");

			logInfo.pass("Opened the browser and enter URL");

		} catch (AssertionError |  Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Given("Enter valid username\\/password")
	public void enter_valid_username_password() throws  IOException {

		ExtentTest logInfo = null;

		try {
			/*ExtentReport statement*/
			logInfo = test.createNode(new GherkinKeyword("Given"),"enter_valid_username_password");
			/*----------------------*/

			TRLoginPage TRLogin_page = new TRLoginPage(driver);
			Properties properties=obj.getProperty(); 

			TRLogin_page.enterUsername(properties.getProperty("TR_username"));

			TRLogin_page.enterPassword(properties.getProperty("TR_password"));

			logInfo.pass("Entered username and password");

		} catch (AssertionError |  Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@When("Click on Login button")
	public void click_on_Login_button() throws InterruptedException {

		ExtentTest logInfo = null;

		try {
			/*ExtentReport statement*/
			logInfo = test.createNode(new GherkinKeyword("When"),"click_on_Login_button");
			/*----------------------*/

			TRLoginPage TRLogin_page = new TRLoginPage(driver);
			TRLogin_page.login_btn_click();
			Thread.sleep(3000);
			logInfo.pass("Click on Login button");

		} catch (AssertionError |  Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("TR Dashboard page is displayed")
	public void tr_Dashboard_page_is_displayed() throws InterruptedException {

		ExtentTest logInfo = null;

		try {
			/*ExtentReport statement*/
			logInfo = test.createNode(new GherkinKeyword("Then"),"tr_Dashboard_page_is_displayed");
			/*----------------------*/
			TRDashboard TRDashboard_page = new TRDashboard(driver);
			TRDashboard_page.hasLoaded();
			Thread.sleep(3000);
			logInfo.pass("Dashboard has loaded");
			driver.quit();

		} catch (AssertionError |  Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);

		}



	}

}