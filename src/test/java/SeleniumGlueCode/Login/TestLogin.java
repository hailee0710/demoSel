package SeleniumGlueCode.Login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.vimalselvam.cucumber.listener.Reporter;

import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import Utilities.GetScreenShot;
import Utilities.ConfigFileReader;
import Utilities.DataProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin{
	
	WebDriver driver;
	HomePage objHomePage;
	LoginPage objLoginPage;
	MyAccountPage objMyAccountPage;
	ConfigFileReader configFileReader;
	DataProvider dataProvider;
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
	
	@Before
	public void setUp() {
		configFileReader = new ConfigFileReader();
    	
    	System.setProperty(configFileReader.getDriverType(),System.getProperty("user.dir") + configFileReader.getDriverPath());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	@After
	public void cleanUp() {
    	driver.quit();
	}
	
	@Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {  
		configFileReader = new ConfigFileReader();
    	driver.get(configFileReader.getUrl());
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
    	Date date = new Date();
        objHomePage = new HomePage(driver);
        objHomePage.clickSignIn();
        
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	Date date = new Date();
    	objLoginPage = new LoginPage(driver);
    	dataProvider = new DataProvider();
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 0));
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 1));
    	objLoginPage.enterEmail(dataProvider.getData("\\Data\\Login_user_data.txt", 0));
    	objLoginPage.enterPasswd(dataProvider.getData("\\Data\\Login_user_data.txt", 1));
        objLoginPage.clickSignIn();  
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));

    }
    
    @When("^user enters non existing username and Password$")
    public void user_enters_non_existing_username_and_Password() throws Throwable{
    	Date date = new Date();
    	objLoginPage = new LoginPage(driver);
    	dataProvider = new DataProvider();
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 2));
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 3));
    	objLoginPage.enterEmail(dataProvider.getData("\\Data\\Login_user_data.txt", 2));
    	objLoginPage.enterPasswd(dataProvider.getData("\\Data\\Login_user_data.txt", 3));
        objLoginPage.clickSignIn();  
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	Date date = new Date();
    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	objMyAccountPage = new MyAccountPage(driver);
    	String actual = objMyAccountPage.getWelcomeText();   	
        Assert.assertEquals(exp_message, actual);
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));

    }  
    
    @Then("^error message is displayed$")
    public void error_message_is_displayed() throws Throwable{
    	Date date = new Date();
    	String exp_message = "Authentication failed.";
    	objLoginPage = new LoginPage(driver);
    	Assert.assertEquals(exp_message, objLoginPage.getErrorMessage());
    	
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
        
    }
    
}
