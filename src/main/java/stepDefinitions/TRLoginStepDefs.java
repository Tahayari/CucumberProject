package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageFactory.TRDashboard;
import pageFactory.TRLoginPage;
import utility.BrowserUtility;
import utility.PropertiesFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TRLoginStepDefs {
	private WebDriver driver;
	PropertiesFileReader obj= new PropertiesFileReader();  

	@Given("^Open browser and access TR page$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{
		Properties properties=obj.getProperty();
		System.out.println(properties.getProperty("browser.name"));
		System.out.println(properties.getProperty("browser.baseURL")+"/tr/login");
		this.driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL")+"/tr/login");
		 	   
	}

	@Given("Enter valid username\\/password")
	public void enter_valid_username_password() throws  IOException {
		TRLoginPage TRLogin_page = new TRLoginPage(driver);
		Properties properties=obj.getProperty(); 
		
		TRLogin_page.enterUsername(properties.getProperty("TR_username"));
		System.out.println("Username is: "+properties.getProperty("TR_username"));
		
		TRLogin_page.enterPassword(properties.getProperty("TR_password"));
		System.out.println("Password is: "+properties.getProperty("TR_password"));
	}

	@When("Click on Login button")
	public void click_on_Login_button() throws InterruptedException {
		TRLoginPage TRLogin_page = new TRLoginPage(driver);
		TRLogin_page.login_btn_click();
		Thread.sleep(3000);
	}

	@Then("TR Dashboard page is displayed")
	public void tr_Dashboard_page_is_displayed() throws InterruptedException {
		TRDashboard TRDashboard_page = new TRDashboard(driver);
		TRDashboard_page.hasLoaded();
		Thread.sleep(3000);
		driver.close();
	}

}