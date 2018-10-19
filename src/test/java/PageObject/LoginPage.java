package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signIn;
	
	@FindBy(id="email_create")
	private WebElement emailSignUp;
	
	@FindBy(id="SubmitCreate")
	private WebElement submitSignUp;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")
	private WebElement errorMessage;
	
	//get error text
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	//fill in email
	public void enterEmail(String strEmail) {
		
		email.sendKeys(strEmail);
	}
	
	//fill in password
	public void enterPasswd(String strPasswd) {
			
		password.sendKeys(strPasswd);
	}
	
	//fill in sign up email
	public void enterEmailSignUp(String strEmail) {
		
		emailSignUp.sendKeys(strEmail);
	}
	
	//click Sign In button
	public void clickSignIn(){
		
		signIn.click();
	}
	
	//Click Sign up button
	public void clickSignUp() {
		
		submitSignUp.click();
	}
}
