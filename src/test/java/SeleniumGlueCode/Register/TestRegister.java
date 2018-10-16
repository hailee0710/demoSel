package SeleniumGlueCode.Register;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.vimalselvam.cucumber.listener.Reporter;

import PageFactory.CreateAccountPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import Utilities.ConfigFileReader;
import Utilities.DataProvider;
import Utilities.GetScreenShot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestRegister {

	WebDriver driver;
	HomePage objHomePage;
	LoginPage objLoginPage;
	MyAccountPage objMyAccountPage;
	CreateAccountPage objCreateAccountPage;
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
	
    @Given("^user is on Homepage$")
    public void user_is_on_Homepage() throws Throwable {  
    	configFileReader = new ConfigFileReader();
    	driver.get(configFileReader.getUrl());

    }
    
	 
	 @When("^user goes to Login Page$")
	    public void user_goes_to_Login_Page() throws Throwable {
			Date date = new Date();
			objHomePage = new HomePage(driver);
	        objHomePage.clickSignIn();
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));

	    }
	    
	   @When("^user enters email and click on Sign Up button$")
	    public void user_enters_username_and_Password() throws Throwable {
			Date date = new Date();
			dataProvider = new DataProvider();
			objLoginPage = new LoginPage(driver);
	    	objLoginPage.enterEmailSignUp(dataProvider.getData("\\Data\\Register_user_data.txt", 0));
	        objLoginPage.clickSignUp();   
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));

	    }
	   
	   @When("^user enters all required information$")
	    public void user_enters_all_required_information() throws Throwable {
			Date date = new Date();
			dataProvider = new DataProvider();
			objCreateAccountPage = new CreateAccountPage(driver);
	    	objCreateAccountPage.selectTitle();
	    	objCreateAccountPage.enterFirstName(dataProvider.getData("\\Data\\Register_user_data.txt", 1));
	    	objCreateAccountPage.enterLastName(dataProvider.getData("\\Data\\Register_user_data.txt", 2));
	    	objCreateAccountPage.enterPassword(dataProvider.getData("\\Data\\Register_user_data.txt", 3));
	    	objCreateAccountPage.selectDate(dataProvider.getData("\\Data\\Register_user_data.txt", 4));
	    	objCreateAccountPage.selectMonth(dataProvider.getData("\\Data\\Register_user_data.txt", 5));
	    	objCreateAccountPage.selectYear(dataProvider.getData("\\Data\\Register_user_data.txt", 6));
	    	objCreateAccountPage.enterAddress(dataProvider.getData("\\Data\\Register_user_data.txt", 7));
	    	objCreateAccountPage.enterCity(dataProvider.getData("\\Data\\Register_user_data.txt", 8));
	    	objCreateAccountPage.selectState(dataProvider.getData("\\Data\\Register_user_data.txt", 9));
	    	objCreateAccountPage.enterPostcode(dataProvider.getData("\\Data\\Register_user_data.txt", 10));
	    	objCreateAccountPage.enterMobile(dataProvider.getData("\\Data\\Register_user_data.txt", 11));
	    	objCreateAccountPage.clickRegisterBtn();
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));

	    	
	    }
	    
	    @Then("^success message is shown$")
	    public void success_message_is_shown() throws Throwable {
	    	
	    	Date date = new Date();
	    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
	    	objMyAccountPage = new MyAccountPage(driver);
	    	String actual = objMyAccountPage.getWelcomeText();   	
	        Assert.assertEquals(exp_message, actual);
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	        
	    }  
	    
	    @Then("^Name is displayed on header$")
	    public void name_is_displayed_on_header() throws Throwable{
	    	
	    	Date date = new Date();
	    	dataProvider = new DataProvider();
	    	objMyAccountPage = new MyAccountPage(driver);
	    	Assert.assertEquals(dataProvider.getData("\\Data\\Register_user_data.txt", 1) + " " + dataProvider.getData("\\Data\\Register_user_data.txt", 2), objMyAccountPage.getUserName());
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	    }
	    

}
