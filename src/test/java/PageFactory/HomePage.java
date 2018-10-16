package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ConfigFileReader;

//Get all elements of Home Page
public class HomePage extends BasePage {
	
	ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void loadHomePage() {
		
	}

	//get Sign in
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement signInBtn;
	
	public void clickSignIn() {
		
		signInBtn.click();
	}
}
