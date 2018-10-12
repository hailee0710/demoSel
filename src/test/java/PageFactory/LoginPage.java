package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
