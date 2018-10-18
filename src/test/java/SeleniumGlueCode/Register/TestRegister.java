package SeleniumGlueCode.Register;

import java.util.Date;

import org.junit.Assert;

import com.vimalselvam.cucumber.listener.Reporter;


import SeleniumGlueCode.BaseStepDefinition.BaseStep;
import Utilities.DataProvider;
import Utilities.GetScreenShot;
import Utilities.PageObjectManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestRegister extends BaseStep{

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void tearDown() {
		if(scenario.isFailed()) {
			Reporter.setTestRunnerOutput(scenario.getStatus() + " --------------------------</br>");
			driver.close();
			}
	}
	
	@Given("^user is on Homepage$")
    public void user_is_on_Homepage() throws Throwable {  
		setup("Start testing Register Feature");
       	Reporter.setTestRunnerOutput("user is on homepage </br>");
    }
    
    @When("^user goes to Login Page$")
    public void user_goes_to_Login_Page() throws Throwable {
    	Date date = new Date();
		pageObjectManager = new PageObjectManager(driver);
    	homePage = pageObjectManager.getHomePage();
        homePage.clickSignIn();
        
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("user navigates to Login Page </br>");

    }
	    
	   @When("^user enters email and click on Sign Up button$")
	    public void user_enters_username_and_Password() throws Throwable {
			Date date = new Date();
			dataProvider = new DataProvider();
			loginPage = pageObjectManager.getLoginPage();
	    	loginPage.enterEmailSignUp(dataProvider.getData("\\Data\\Register_user_data.txt", 0));
	        loginPage.clickSignUp();   
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	    	Reporter.setTestRunnerOutput("user enters email and click on Sign Up button </br>");

	    }
	   
	   @When("^user enters all required information$")
	    public void user_enters_all_required_information() throws Throwable {
			Date date = new Date();
			createAccountPage = pageObjectManager.getCreateAccountPage();
	    	createAccountPage.selectTitle();
	    	createAccountPage.enterFirstName(dataProvider.getData("\\Data\\Register_user_data.txt", 1));
	    	createAccountPage.enterLastName(dataProvider.getData("\\Data\\Register_user_data.txt", 2));
	    	createAccountPage.enterPassword(dataProvider.getData("\\Data\\Register_user_data.txt", 3));
	    	createAccountPage.selectDate(dataProvider.getData("\\Data\\Register_user_data.txt", 4));
	    	createAccountPage.selectMonth(dataProvider.getData("\\Data\\Register_user_data.txt", 5));
	    	createAccountPage.selectYear(dataProvider.getData("\\Data\\Register_user_data.txt", 6));
	    	createAccountPage.enterAddress(dataProvider.getData("\\Data\\Register_user_data.txt", 7));
	    	createAccountPage.enterCity(dataProvider.getData("\\Data\\Register_user_data.txt", 8));
	    	createAccountPage.selectState(dataProvider.getData("\\Data\\Register_user_data.txt", 9));
	    	createAccountPage.enterPostcode(dataProvider.getData("\\Data\\Register_user_data.txt", 10));
	    	createAccountPage.enterMobile(dataProvider.getData("\\Data\\Register_user_data.txt", 11));
	    	createAccountPage.clickRegisterBtn();
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	    	Reporter.setTestRunnerOutput("user enters all required information </br>");

	    	
	    }
	    
	    @Then("^success message is shown$")
	    public void success_message_is_shown() throws Throwable {	    	
	    	Date date = new Date();
	    	String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
	    	myAccountPage = pageObjectManager.getMyAccountPage();
	    	String actual = myAccountPage.getWelcomeText();   	
	        Assert.assertEquals(exp_message, actual);
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	    	Reporter.setTestRunnerOutput("success message is shown </br>");

	    }  
	    
	    @Then("^Name is displayed on header$")
	    public void name_is_displayed_on_header() throws Throwable{	    	
	    	Date date = new Date();
	    	Assert.assertEquals(dataProvider.getData("\\Data\\Register_user_data.txt", 1) + " " + dataProvider.getData("\\Data\\Register_user_data.txt", 2), myAccountPage.getUserName());
	        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
	    	Reporter.setTestRunnerOutput("Name is displayed on header </br> --------------------------</br>");
	    	driver.close();
	    }
	    

}
