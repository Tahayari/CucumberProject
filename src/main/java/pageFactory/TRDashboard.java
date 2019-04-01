package pageFactory;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TRDashboard {

	WebDriver driver;
	@FindBy(xpath="//a[@href='/tr/new-lead']//button[@type='button']") WebElement addNewTR_btn;
	
	
	public TRDashboard(WebDriver driver){
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this);
	}
	
	public void hasLoaded(){
		Assert.assertEquals(addNewTR_btn.getText(), "Adaugă Recomandare nouă");
	}
	
	
	
}
