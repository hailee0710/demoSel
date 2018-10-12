package SeleniumGlueCode.Login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vimalselvam.cucumber.listener.Reporter;

import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import Utilities.GetScreenShot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestLogin {
	
	WebDriver driver;
	HomePage objHomePage;
	LoginPage objLoginPage;
	MyAccountPage objMyAccountPage;
	
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.gecko.driver","D:\\Projects\\WiPro\\eclipse-workspace\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        objHomePage = new HomePage(driver);
        objHomePage.clickSignIn();
        
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName1"));
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	objLoginPage = new LoginPage(driver);
    	objLoginPage.enterEmail("blog.cucumber@gmail.com");
    	objLoginPage.enterPasswd("Cucumber@blog");
        objLoginPage.clickSignIn();  
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName2"));

    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	
    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	objMyAccountPage = new MyAccountPage(driver);
    	String actual = objMyAccountPage.getWelcomeText();   	
        Assert.assertEquals(exp_message, actual);
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName3"));

        driver.quit();  
    }      
}
