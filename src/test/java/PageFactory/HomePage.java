package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Get all elements of Home Page
public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//get Sign in
	@FindBy(linkText="Sign in")
	private WebElement signInBtn;
	
	public void clickSignIn() {
		
		signInBtn.click();
	}
}
