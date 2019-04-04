package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TRLoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='login_form_username']") public WebElement username_field;
	@FindBy(xpath="//input[@name='password']") public WebElement password_field;
	@FindBy(xpath="//button[@type='submit']") public WebElement login_btn;
	
	
	public TRLoginPage (WebDriver driver){
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}
	
	public void enterUsername(String user){
		username_field.click();
		username_field.sendKeys(user);		
	}
	
	public void enterPassword(String pass){
		password_field.click();
		password_field.sendKeys(pass);
	}
	
	public void login_btn_click(){
		login_btn.click();
	}
	
	public void login(String user,String pass){
		enterUsername(user);
		enterPassword(pass);
		login_btn_click();
	}
}
