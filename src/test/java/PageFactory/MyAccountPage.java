package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
