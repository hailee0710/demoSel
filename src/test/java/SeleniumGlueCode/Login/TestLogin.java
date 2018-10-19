package SeleniumGlueCode.Login;

import java.util.Date;

import com.vimalselvam.cucumber.listener.Reporter;

import SeleniumGlueCode.BaseStepDefinition.BaseStep;
import Utilities.GetScreenShot;
import Utilities.PageObjectManager;
import Utilities.DataProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class TestLogin extends BaseStep{
	
	

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After("@DoAfterLoginSuccess")
	public void tearDown() {
		endIfFailed();
	}
	
	//Common steps
	@Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {  
		setUp(scenario.getName());
       	Reporter.setTestRunnerOutput("user is on homepage </br>");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
    	Date date = new Date();
		pageObjectManager = new PageObjectManager(driver);
    	homePage = pageObjectManager.getHomePage();
        homePage.clickSignIn();
        
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("user navigates to Login Page </br>");

    }
    
    //Valid Login
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	Date date = new Date();
    	loginPage = pageObjectManager.getLoginPage();
    	dataProvider = new DataProvider();
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 0));
    	System.out.println(dataProvider.getData("\\Data\\Login_user_data.txt", 1));
    	loginPage.enterEmail(dataProvider.getData("\\Data\\Login_user_data.txt", 0));
    	loginPage.enterPasswd(dataProvider.getData("\\Data\\Login_user_data.txt", 1));
        loginPage.clickSignIn();  
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("user enters username and Password </br>");


    }
       
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	Date date = new Date();
    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	myAccountPage = pageObjectManager.getMyAccountPage();
    	String actual = myAccountPage.getWelcomeText();   	
        Assert.assertEquals(exp_message, actual);
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("success message is displayed </br> --------------------------</br>");
    	driver.close();

    }  
    
    //non-existing user
    @When("^user enters non existing username and Password$")
    public void user_enters_non_existing_username_and_Password() throws Throwable{
    	Date date = new Date();
    	dataProvider = new DataProvider();
    	loginPage = pageObjectManager.getLoginPage();
    	loginPage.enterEmail(dataProvider.getData("\\Data\\Login_user_data.txt", 2));
    	loginPage.enterPasswd(dataProvider.getData("\\Data\\Login_user_data.txt", 3));
        loginPage.clickSignIn();  
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("user enters non existing username and Password </br>");

    }
        
    @Then("^error message is displayed$")
    public void error_message_is_displayed() throws Throwable{
    	Date date = new Date();
    	String exp_message = "Authentication failed.";
    	Assert.assertEquals(exp_message, loginPage.getErrorMessage());
    	
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("error message is displayed </br> --------------------------</br>");
        driver.close();
    }
   
    
}
