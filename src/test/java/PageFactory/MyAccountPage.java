package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".info-account")
	private WebElement welcomeText;
	
	@FindBy(css=".account")
	private WebElement user;
	
	//get welcome text
	public String getWelcomeText() {
		
		return welcomeText.getText();
	}
	
	//get user name
	public String getUserName() {
		
		return user.getText();
	}
}
