package SeleniumGlueCode.Register;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import PageFactory.CreateAccountPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import Utilities.ConfigFileReader;
import Utilities.GetScreenShot;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestRegister {

	WebDriver driver;
	ConfigFileReader configFileReader;
	HomePage objHomePage;
	LoginPage objLoginPage;
	MyAccountPage objMyAccountPage;
	CreateAccountPage objCreateAccountPage;
	
	 @Given("^user is on Homepage$")
	 public void user_is_on_homepage() throws Throwable {  
	    	configFileReader = new ConfigFileReader();
	    	
	    	System.setProperty(configFileReader.getDriverType(),System.getProperty("user.dir") + configFileReader.getDriverPath());
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	        driver.get(configFileReader.getUrl());
	    }
	 
	 @When("^user goes to Login Page$")
	    public void user_goes_to_Login_Page() throws Throwable {
	        objHomePage = new HomePage(driver);
	        objHomePage.clickSignIn();
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName4"));

	    }
	    
	   @When("^user enters email and click on Sign Up button$")
	    public void user_enters_username_and_Password() throws Throwable {
	    	objLoginPage = new LoginPage(driver);
	    	objLoginPage.enterEmailSignUp("hai16@qa.team");
	        objLoginPage.clickSignUp();   
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName5"));

	    }
	   
	   @When("^user enters all required information$")
	    public void user_enters_all_required_information() throws Throwable {
	    	objCreateAccountPage = new CreateAccountPage(driver);
	    	objCreateAccountPage.selectTitle();
	    	objCreateAccountPage.enterFirstName("Hai");
	    	objCreateAccountPage.enterLastName("Lee");
	    	objCreateAccountPage.enterPassword("abc1234");
	    	objCreateAccountPage.selectDate("26");
	    	objCreateAccountPage.selectMonth("10");
	    	objCreateAccountPage.selectYear("1991");
	    	objCreateAccountPage.enterAddress("abc");
	    	objCreateAccountPage.enterCity("Hanoi");
	    	objCreateAccountPage.selectState("Alabama");
	    	objCreateAccountPage.enterPostcode("10001");
	    	objCreateAccountPage.enterMobile("12345678");
	    	objCreateAccountPage.clickRegisterBtn();
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName6"));

	    	
	    }
	    
	    @Then("^success message is shown$")
	    public void success_message_is_shown() throws Throwable {
	    	
	    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
	    	objMyAccountPage = new MyAccountPage(driver);
	    	String actual = objMyAccountPage.getWelcomeText();   	
	        Assert.assertEquals(exp_message, actual);
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName7"));
	        
	    }  
	    
	    @Then("^Name is displayed on header$")
	    public void name_is_displayed_on_header() throws Throwable{
	    	
	    	objMyAccountPage = new MyAccountPage(driver);
	    	Assert.assertEquals("Hai Lee", objMyAccountPage.getUserName());
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, "screenShotName8"));
	    }
	    
	    @After
	    public void afterScenario() {
	    	driver.quit();
	    }
	 
}
